RealTime Chat App with Toastr Push Notification

https://www.yamicode.com/snippets/real-time-chat-angular-spring-boot-java-websocket-stompjs

To run angular:
1. cd directory
2. npm install
3. ng serve


Set up new angular app:
1. g new socket-angular --routing
2. npm install stompjs --save
3. npm install sockjs-client --save
4. npm install jquery
5. npm i net -S
6. npm install ngx-toastr --save
7. npm install @angular/animations --save
8. in angular.json add "styles": [
              "src/styles.css",
              "node_modules/ngx-toastr/toastr.css"
            ]
9. ng g c components/yami-code-socket --spec false
10. ng g s services/socket --spec false
