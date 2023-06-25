const express = require('express')
const app = express();
const port = 8089;
app.get('/', function(req,res){
    res.sendFile('C:/Users/user/OneDrive - ФГОБУ ВО Финансовый университет при Правительстве РФ/Рабочий стол/Ксюша/ВЕБ/2сем/index.html')
})
app.listen(port);
console.log('Сервер запущен!');
