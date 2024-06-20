let DATA;
let ingame=false;
let punteggio = 0;
let ncard = 0;
let selected;

function change(tipo, domande){
	mostra(tipo)
}

async function startQuiz(){
	document.getElementById('quiz').style.display = 'flex';
	document.getElementById('training').style.display = 'none';
	punteggio = 0;
	ncard = 0;
	ingame = true;
	callBE('quiz',1);
}

function nextQuiz(){
	console.log(DATA)
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

function startTraining(){

	if(!DATA.foto){
		document.getElementById('training-card').innerHTML = `
	<img src="${DATA.soluzione}" alt="" srcset="">
	<div class="card-body">
		<h5 class="card-title">${DATA.pokemon}/h5>
	</div>
	<button type="button" class="btn btn-primary" id='training-next'>Continua</button>
	`;
	}else{
		document.getElementById('training-card').innerHTML = `
	<img src="${DATA.foto}" alt="" srcset="">
	<div class="card-body">
		<h5 class="card-title">${DATA.pokemon}</h5>
		<p>${DATA.soluzione}</p>
	</div>
	<button type="button" class="btn btn-primary" id='training-next'>Continua</button>
	`;
	}

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

async function callBE(tipo, domande){
	let requestOptions = {
		method: 'GET',
		redirect: 'follow'
	  };
	  
	  fetch("http://127.0.0.1:8090/pokemon/domande", requestOptions)
		.then(response => response.json())
		.then(result => {
			DATA = result;
			nextQuiz();
		})
		.catch(error => console.log('error', error));
}

document.getElementById('quiz-ris-a').addEventListener('click', ()=>{
	selected = 0;
	document.getElementById('quiz-conferma').style.display = 'block';
	if(DATA[ncard].risposte[selected] == DATA[ncard].soluzione)
		punteggio++;
	else
		console.log('scemo')
	ncard++;
	if(ncard==DATA.length)
		fineQuiz();
	else
		nextQuiz();
});
document.getElementById('quiz-ris-b').addEventListener('click', ()=>{
	selected = 1;
	document.getElementById('quiz-conferma').style.display = 'block';
	if(DATA[ncard].risposte[selected] == DATA[ncard].soluzione)
		punteggio++;
	else
		console.log('scemo')
	ncard++;
	if(ncard==DATA.length)
		fineQuiz();
	else
		nextQuiz();
});
document.getElementById('quiz-ris-c').addEventListener('click', ()=>{
	selected = 2;
	document.getElementById('quiz-conferma').style.display = 'block';
	if(DATA[ncard].risposte[selected] == DATA[ncard].soluzione)
		punteggio++;
	else
		console.log('scemo')
	ncard++;
	if(ncard==DATA.length)
		fineQuiz();
	else
		nextQuiz();
});

/*
document.getElementById('training-next').addEventListener('click',()=>{
	
});
*/
