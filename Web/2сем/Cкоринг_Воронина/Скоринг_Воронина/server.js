const express = require('express');
//const mongoClient = require('mongodb').MongoClient;
const app = express();
const port = 3000;

var server = require('http').createServer(app);

const request = require('request');
const rp = require('request-promise');
const cheerio = require('cheerio');


app.use(express.static('public'));
app.use(express.urlencoded({
    extended: true
})
);

app.get('/scoring', function (req, res) {
    res.sendFile('C:/Users/user/OneDrive - ФГОБУ ВО Финансовый университет при Правительстве РФ/Рабочий стол/Ксюша/ВЕБ/2сем/Cкоринг_Воронина/public');
});


app.post('//scoring', (req, res)=>{

    request('http://localhost:8081/hello', (err, response, body)=>{
        console.log(body);
    });

    var option = {
        method: 'POST',
        url: 'http:/localhost:8081/python',
        body: req.body,
        json: true
    };

    rp(option)
        .then(function (parsedBody){
            if (parsedBody >= 1.4) res.send('good');
            else res.send('bad');
        })
        .catch(function (err){
            res.send('error');
        });

    /*console.log(req.body);
    const date = new Date();
    var i = 0;
    var result = 0;
    var gender = req.body.gender;
    var birthD = new Date(req.body.birthD);
    var birthYear = date.getFullYear() - birthD.getFullYear();
    var period = req.body.period;
    var prof = req.body.prof;
    var sphere = req.body.sphere;
    var peroidW = req.body.periodW;

    try {
        if (req.body.bank =='on') {
            result += 0.45;
        }
    } catch {
        result += 0;
    }

    try {
        if (req.body.real == 'on') {
            result += 0.35;
        }
    } catch {
        result += 0;
    }

    try {
        if (req.body.policy == 'on') {
            result += 0.19;
        }
    } catch {
        result += 0;
    }

    if (gender == 'female') {
        result = result + 0.4;
    };

    if (birthYear > 20) {
        do {
            i = i + 0.01;
            birthYear -= 1;
        } while ((i < 0.3)&&((birthYear-20)>0));

        result += i;
        i = 0;
    }

    do {
        i = i + 0.042;
        period -= 1;
    } while ((i < 0.42)&&(period>0));
    result += i;
    i = 0;

    if ((prof == 'policeman')||(prof == 'pilot')){
        result = result + 0;
    } else {
        result = result + 0.55;
    }

    if (sphere == 'public') {
        result += 0.21;
    }

    do {
        i = i + 0.059;
        peroidW-= 1;
    } while ((i < 0.59)&&(peroidW>0));
    result += i;*/


    /*if (result >= 1.25) {

        res.send(`Одобрено! ${result}`);

    } else {
        res.send(`Не одобрено! ${result}`);
    }*/
});

server.listen(port, function (){
    console.log('listening on port 3000');
});