FROM node:16
WORKDIR /usr/src/app
COPY package.json .
RUN npm i -g @angular/cli@~16.2.4
RUN npm i
COPY . .
RUN ng build
CMD ng serve --host 0.0.0.0
