const express = require('express');
const cheerio = require('cheerio');
const request = require('request');
const rp = require('request-promise');
const cyrillicToTranslit = require('cyrillic-to-translit-js');
const vkbot = require('node-vk-bot-api');
const bodyParser = require('body-parser');
const Markup = require('node-vk-bot-api/lib/markup')

const port = 3000;
const app = express();
//const server = require('http').createServer(app);
app.use(bodyParser.json());

const token = '801fd4c406715d43fbbe1539a3cfbd72e83feabc6f35709162c0c594d3da7c63d6d52ef2e8136ce4300d3';
const param = '0a237486';

const bot = new vkbot({
    token: token,
    confirmation: param
});

bot.command('/start', (ctx)=> {
    ctx.reply('Выберите город', null, Markup
        .keyboard([
            [
                Markup.button('Москва', 'negative'),
            ],
            [
                Markup.button('Волгоград', 'positive')
            ],
            [
                Markup.button('Краснодар', 'primary'),
            ],
        ]),
    );

});

bot.on((ctx)=>{
    let city = ctx.message.text;
    city = cyrillicToTranslit().transform(city, "_");
    const url = `https://pogoda.mail.ru/prognoz/${city}`;
    rp(url)
        .then(function (html){
            const $ = cheerio.load(html);
            let data = [];
            $('body > div.g-layout.layout.layout_banner-side.js-module > div:nth-child(2) > div.block.block_forecast.block_index.forecast-rb-bg > div > div.information.block.js-city_one > div.information__content > div.information__content__wrapper.information__content__wrapper_left > a > div.information__content__additional.information__content__additional_first > div').each((idx, elem)=>{
                const title = $(elem).text().trim();
                data.push(title);
                //console.log(title);

            });

            $('body > div.g-layout.layout.layout_banner-side.js-module > div:nth-child(2) > div.block.block_forecast.block_index.forecast-rb-bg > div > div.information.block.js-city_one > div.information__content > div.information__content__wrapper.information__content__wrapper_left > a > div.information__content__additional.information__content__additional_temperature > div.information__content__temperature').each((idx,elem)=>{
                const title = $(elem).text().trim();
                data.push(title);
                //console.log(title);
                ctx.reply(data[0]+' '+data[1])
            });

            //console.log(html);
            //res.send(html);
        })
        .catch(function (err) {
            ctx.reply('Ваш город не найден ', null, Markup
                .keyboard([
                    Markup.button({
                        action: {
                            type: 'open_link',
                            link: 'https://yandex.ru/pogoda/?utm_campaign=informer&utm_medium=web&utm_source=home&utm_content=main_informer&utm_term=title',
                            label: 'ЯндексПогода',
                            payload: JSON.stringify({
                                url: 'https://yandex.ru/pogoda/?utm_campaign=informer&utm_medium=web&utm_source=home&utm_content=main_informer&utm_term=title',
                            }),
                        },
                    }),
                ]),
            );
        })

    //ctx.reply('Добро пожаловать!:)');
});

/*app.get('/get/:city', (req, res)=> {
    let city = req.params.city;
    city = cyrillicToTranslit().transform(city, "_");
    const url = `https://pogoda.mail.ru/prognoz/${city}`;
    rp(url)
        .then(function (html){
            const $ = cheerio.load(html);
            let data = [];
            $('body > div.g-layout.layout.layout_banner-side.js-module > div:nth-child(2) > div.block.block_forecast.block_index.forecast-rb-bg > div > div.information.block.js-city_one > div.information__content > div.information__content__wrapper.information__content__wrapper_left > a > div.information__content__additional.information__content__additional_first > div').each((idx, elem)=>{
                const title = $(elem).text().trim();
                data.push(title);
                console.log(title);
            });

            $('body > div.g-layout.layout.layout_banner-side.js-module > div:nth-child(2) > div.block.block_forecast.block_index.forecast-rb-bg > div > div.information.block.js-city_one > div.information__content > div.information__content__wrapper.information__content__wrapper_left > a > div.information__content__additional.information__content__additional_temperature > div.information__content__temperature').each((idx,elem)=>{
                const title = $(elem).text().trim();
                data.push(title);
                console.log(title);
            });

            //console.log(html);
            //res.send(html);
        })
        .catch(function (err) {
            console.log(err);
        })

});*/

app.post('/', bot.webhookCallback);

app.listen(port, function () {
    console.log(`listening on ${port}`);
});