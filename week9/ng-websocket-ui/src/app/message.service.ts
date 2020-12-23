import { Injectable } from '@angular/core';
declare var SockJS: any;
declare var Stomp: any;

@Injectable({
  providedIn: 'root',
})
export class MessageService {
  constructor() {
    this.initializeWebSocketConnection();
  }

  public stompClient;
  public msg = [];

  initializeWebSocketConnection() {
    // const serverUrl = 'http://localhost:8080/spring-websocket/test-socket';
    //   const serverUrl = 'http://localhost:8080/spring-websocket/cool-websocket/47';
    //   const ws = new SockJS(serverUrl);
    //   this.stompClient = Stomp.over(ws);
    //   const that = this;
    //   this.stompClient.connect({}, function(frame) {
    //     that.stompClient.subscribe('/message', (message) => {
    //       if (message.body) {
    //         that.msg.push(message.body);
    //       }
    //     });
    //   });
    // }
    // sendMessage(message) {
    //   this.stompClient.send('/app/send/message' , {}, message);
    // }
    // getMessages() {
    //   this.stompClient.send('/app/get/messages');
    // }
  }
}
