let DATA=[{
	"pokemon": "AAA",
	"risposte": ['https://img.pokemondb.net/sprites/home/normal/2x/absol.jpg', 'https://img.pokemondb.net/sprites/home/normal/2x/pikachu.jpg', 'https://img.pokemondb.net/sprites/home/normal/2x/incineroar.jpg'],
	"soluzione": 'https://img.pokemondb.net/sprites/home/normal/2x/absol.jpg'
}, {
	"pokemon": "BBB",
	"risposte": ['a', 'b', 'c'],
	"soluzione": 'c',
	"foto": "https://img.pokemondb.net/sprites/home/normal/2x/absol.jpg"
}];
let ingame=false;
let punteggio = 0;
let ncard = 0;
let selected;

function change(tipo, domande){
	switch(domande){
		case "generale": callGenerale(tipo); break;
		case "foto": callFoto(tipo); break;
		case "misto": callMisto(tipo); break;
		default: console.log('tipo sbagliato, coglione'); break;
	}
}

function startQuiz(){
	document.getElementById('quiz').style.display = 'flex';
	document.getElementById('training').style.display = 'none';
	punteggio = 0;
	ncard = 0;
	ingame = true;
	nextQuiz();
}

function nextQuiz(){
	if(!DATA[ncard].foto){
		document.getElementById('quiz-ris-a').innerHTML = `<img src="${DATA[ncard].risposte[0]}" alt="" srcset="">`;
		document.getElementById('quiz-ris-b').innerHTML = `<img src="${DATA[ncard].risposte[1]}" alt="" srcset="">`;
		document.getElementById('quiz-ris-c').innerHTML = `<img src="${DATA[ncard].risposte[2]}" alt="" srcset="">`;
		document.getElementById('quiz-img').src = '';
	}else{
		document.getElementById('quiz-ris-a').innerHTML = DATA[ncard].risposte[0];
		document.getElementById('quiz-ris-b').innerHTML = DATA[ncard].risposte[1];
		document.getElementById('quiz-ris-c').innerHTML = DATA[ncard].risposte[2];
		document.getElementById('quiz-img').src = DATA[ncard].foto;
	}
	document.getElementById('quiz-nome').innerHTML = DATA[ncard].pokemon;
}

function fineQuiz(){
	ingame = false;
	document.getElementById('quiz').style.display = 'none';
	document.getElementById('home').style.display = 'flex';
	document.getElementById('display-result').innerHTML = `RISULTATO QUIZ = ${punteggio}`;
	document.getElementById('display-result').style.display = 'block';
}

function mostra(tipo){
	if(ingame){
		if(!confirm('Sei in partita, sicuro di voler interrompere?')){
			return;
		}
	}
	document.getElementById('home').style.display = 'none';
	switch(tipo){
		case 'quiz': 
			startQuiz();
			break;
		case 'training':
			document.getElementById('training').style.display = 'flex';
			document.getElementById('quiz').style.display = 'none';
			ingame = false;
			startTraining();
			break;
		case 'home':
			document.getElementById('quiz').style.display = 'none';
			document.getElementById('training').style.display = 'none';
			document.getElementById('home').style.display = 'flex';
			ingame = false;
			break;
	}
}

function callGenerale(tipo){
	//fetch
	mostra(tipo)
}

function callFoto(tipo){
	
	mostra(tipo)
}

function callMisto(tipo){

	mostra(tipo)
}

document.getElementById('quiz-ris-a').addEventListener('click', ()=>{
	selected = 0;
	document.getElementById('quiz-conferma').style.display = 'block';
});
document.getElementById('quiz-ris-b').addEventListener('click', ()=>{
	selected = 1;
	document.getElementById('quiz-conferma').style.display = 'block';
});
document.getElementById('quiz-ris-c').addEventListener('click', ()=>{
	selected = 2;
	document.getElementById('quiz-conferma').style.display = 'block';
});
document.getElementById('quiz-conferma').addEventListener('click', ()=>{
	document.getElementById('quiz-conferma').style.display = 'none';
	if(DATA[ncard].risposte[selected] == DATA[ncard].soluzione)
		punteggio++;
	ncard++;
	if(ncard==DATA.length)
		fineQuiz();
	else
		nextQuiz();
});