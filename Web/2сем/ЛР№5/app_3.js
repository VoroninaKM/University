const path = require('path');
const app = require('express')();
const http = require('http').Server(app);
const io = require('socket.io')(http);
const nodemailer = require('nodemailer');

const port = 5000;
const config = require('./config.json');
//var server = require('http').createServer(app);
//const io = new Server(port);

// Когда клиент соединяется, выводим сообщение в консоль
io.on('connection', function (socket) {
  console.log('A client is connected!');
  socket.emit('message', 'You are connected!');
  
  socket.on('eventClient', function (data) {
    console.log('message from client: ' +data.message+' '+ data.recipient);
    let transporter = nodemailer.createTransport({
      host: 'smtp.gmail.com',
      port: 465,
      secure: true,
      auth: config,
    })
    
    let result =  transporter.sendMail({
      from: 'Ksenia Voronina', //подпись
      to: data.recipient, //получатель
      subject: 'Семинар',
      text: data.message,
      // html: data.message,
    })
    
    console.log(result)
}); 
});

const filePath = path.resolve('index_3.html');

app.get('/', (req, res)=>{
    res.sendFile(filePath);
});

http.listen(port, function(){
    console.log(`Listening on port ${port}`);
});