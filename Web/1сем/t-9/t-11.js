/* 4. Создайте методы exportStr() у каждого из объектов. Этот метод
должен возвращать информацию о городе в формате
«name=ГородN\npopulation=10000 000\n». Для второго города
будет строка со своими значениями. Примечание: можно
обращаться к каждому свойству через цикл for/in, но методы
объекта возвращать не нужно */

function ExportStr(props) {
    return <h1>name = {props.name}, population = {props.population}</h1>;
}

function App() {
    return (
        <div>
            <ExportStr name="Город1" population="1000000"/>
            <ExportStr name="Город2" population="2000000"/>
            <ExportStr name="Город3" population="3000000"/>
        </div>
    );
}

ReactDOM.render(<App />, document.getElementById('root'));