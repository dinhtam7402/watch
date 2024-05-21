var stompClient = null;
var username = null;
var phoneNumber = null;

document.getElementById('liveChatButton').addEventListener('click', function () {
    var liveChatBox = document.getElementById('liveChatBox');
    if (liveChatBox.style.display === 'none' || liveChatBox.style.display === '') {
        liveChatBox.style.display = 'block';
        connect();
    } else {
        liveChatBox.style.display = 'none';
    }
});

function connect() {
    var socket = new SockJS('/ws');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/public', function (chatMessage) {
            showMessage(JSON.parse(chatMessage.body));
        });
    });
}

function sendMessage() {
    var messageContent = document.getElementById('message').value;
    if (messageContent && stompClient) {
        var chatMessage = {
            from: username,
            phoneNumber: phoneNumber,
            content: messageContent,
            type: 'CHAT'
        };
        stompClient.send("/app/chat.sendMessage", {}, JSON.stringify(chatMessage));
        document.getElementById('message').value = '';
    }
}

document.getElementById('send').addEventListener('click', function () {
    username = document.getElementById('name').value;
    phoneNumber = document.getElementById('phone').value;
    if (username && phoneNumber) {
        sendMessage();
    } else {
        alert("Please enter your name and phone number.");
    }
});

function showMessage(message) {
    var chatContent = document.querySelector('.chat-content');
    var messageElement = document.createElement('div');
    messageElement.appendChild(document.createTextNode(message.from + ": " + message.content));
    chatContent.appendChild(messageElement);
    chatContent.scrollTop = chatContent.scrollHeight;
}