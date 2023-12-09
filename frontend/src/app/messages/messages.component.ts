import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { ChatService } from '../chat.service';
import {Router} from '@angular/router';
import {environment} from "../../../environment";

export interface MessagesLogsDto {
  id: number,
  fullUsername: string,
  userMessageTime: Date,
  userMessage: string,
  adminResponseTime: Date,
  adminResponse: string
}

interface AdminMessageRequestDto {
  adminResponse: string
}

interface AdminMessageResponseDto {
  message: string
}

interface AdminResponseDto {
  email: string
}

@Component({
  selector: 'app-logs',
  templateUrl: './messages.component.html',
  styleUrls: ['./messages.component.scss']
})

export class MessagesComponent implements OnInit {
    messagesList: MessagesLogsDto[] = [];
    admin: AdminResponseDto | undefined;
    id: number | undefined;
    isPopupOpen: boolean = false;
    message: string = ''

    constructor(
        private http: HttpClient,
        private router: Router,
        private authService: AuthService,
        private chatService: ChatService,
    ) {
    }

    ngOnInit(): void {
        this.loadChatLogs();
        this.getAdmin();
        this.loadChatLogs();
    }

    setChatId(id: number): void {
        this.chatService.setChatId(id);
    }

    loadChatLogs(): void {
        const headers = this.authService.getAuthorizationHeader();
        const serverUrl = environment.serverUrl

        this.http.get<MessagesLogsDto[]>(`${serverUrl}/messages`, { headers })
            .subscribe(
                (data: MessagesLogsDto[]) => {
                    this.messagesList = data;
                    this.setChatId(data[0]?.id);
                },
                error => {
                    console.error('Error fetching chat list:', error);
                }
            );
    }

    getAdmin() {
        const headers = this.authService.getAuthorizationHeader()
        const serverUrl = environment.serverUrl

        this.http.get<AdminResponseDto>(`${serverUrl}/admin`, { headers })
            .subscribe(
                (data: AdminResponseDto) => {
                    this.admin = data;
                },
                error => {
                    console.error('Error fetching admin data:', error);
                }
            );
    }

  sendMessage(message: string) {
    const headers = this.authService.getAuthorizationHeader();
    const serverUrl = environment.serverUrl
    const body: AdminMessageRequestDto = {
      adminResponse: message
    };
    this.http.post<AdminMessageResponseDto>(`${serverUrl}/reply/${this.id}`, body, { headers })
      .subscribe(
        (response: AdminMessageResponseDto) => {
          console.log('Server response:', response.message);
        },
        error => {
          console.error('Error sending message:', error);
        }
      );
    this.closePopup();
  }

    onChatIdClick(chatId: number): void {
        this.setChatId(chatId);
        this.router.navigate(['/logs', chatId]);
    }

    logout() {
        this.authService.logout();
    }

  openPopup(id: number) {
    this.isPopupOpen = true;
    this.id = id;
    console.log('Popup should open for log with ID:', id);
  }

  closePopup() {
    this.isPopupOpen = false;
  }
}
