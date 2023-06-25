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
  console.log('Клиент присоединился!');
  socket.emit('message', 'Вы присоеденились');
  
  socket.on('eventClient', function (data) {
    console.log('Сообщение от клиента: ' +data.message+' '+ data.mail);
    let transporter = nodemailer.createTransport({
      host: 'smtp.gmail.com',
      port: 465,
      secure: true,
      auth: config,
    })
    
    let result =  transporter.sendMail({
      from: 'Воронина Ксения',
      to: data.mail,
      subject: 'Пример',
      text: data.message,
      //html: data.message,
    })
    
    console.log(result)
}); 
});

const filePath = path.resolve('index.html');

app.get('/', (req, res)=>{
    res.sendFile(filePath);
});




http.listen(port, function(){
    console.log(`Listening on port ${port}`);
});
//nodemon если забыл указать почту написать почта не заполнена