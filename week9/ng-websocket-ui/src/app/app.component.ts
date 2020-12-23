import { Component } from '@angular/core';
import { MessageService } from './message.service';
//by default looks in /assets
//"Ambient Declarations"
declare var SockJS: any;
declare var Stomp: any;

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'websocket-frontend';
  input: string;
  roomId: number = 1;
  otherRoomId: number = 2;
  username: string;


  public msg = [];
  public stompClient;
  

  constructor(private messageService: MessageService) {}
  // sendMessage() {
  //   if (this.input) {
  //     this.messageService.sendMessage(this.input);
  //     this.input = '';
  //   }
  // }

  // getMessages() {
  //   this.messageService.getMessages();
  // }

  roomOne() {
    this.roomId = 1;
    this.otherRoomId = 2;
    console.log(`current chatroom: ${this.roomId}`);
  }

  roomTwo() {
    this.roomId = 2;
    this.otherRoomId = 1;
    console.log(`current chatroom: ${this.roomId}`);
  }

  userOne() {
    this.username = "userOne";
    console.log(`current user: ${this.username}`);
  }

  userTwo() {
    this.username = "userTwo";
    console.log(`current user: ${this.username}`);
  }

  userThree() {
    this.username = "userThree";
    console.log(`current user: ${this.username}`);
  }

  userFour() {
    this.username = "userFour";
    console.log(`current user: ${this.username}`);
  }

  connectToWebsocket() {
    const websocket = new SockJS(`http://localhost:8080/spring-websocket/test-socket`)
    this.stompClient = Stomp.over(websocket);
    // this.stompClient.debug = null;
    this.stompClient.connect({}, function(frame) {
    });
  }

  subscribeToRoom() {
    // const websocket = new SockJS(`http://localhost:8080/spring-websocket/test-socket`)
    // this.stompClient = Stomp.over(websocket);
    // const that = this;
    // let roomId = this.roomId;
    // this.stompClient.connect({}, function(frame) {
      this.stompClient.unsubscribe(this.otherRoomId, {});
      this.stompClient.subscribe(`/chatroom/${this.roomId}`, (message)=>{
        if(message.body){
          this.msg.push(message.body);
        }
      },{id:this.roomId});
    // });
  }

    sendMessage() {
      if (this.input) {
      this.stompClient.send(`/app/coolMessageEndpoint/${this.roomId}/username/${this.username}` , {}, this.input);
      this.input = '';
    }
    }

    getMessages() {
      this.msg.push("--------------chat history--------------")
      this.collectMessages();
      this.connectMessages();
    }

    connectMessages() {
      this.stompClient.subscribe(`/history/${this.username}`, (pastmessages)=>{
        if(pastmessages.body){
          this.msg.push(pastmessages.body);
        }
      },{id:this.username});
    }

    collectMessages() {
      this.stompClient.send(`/app/get/messages/${this.username}/chatroom/${this.roomId}`);
    }

    addToMesg() {
      this.msg.push("test mesg");
    }

    ngOnInit() {
      this.connectToWebsocket();
    }
}