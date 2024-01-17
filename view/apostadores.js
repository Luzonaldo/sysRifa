
const divTabela = document.querySelector("[tabela]")

const urlAPI = divTabela.getAttribute("tabela")

const xmlHttp = new XMLHttpRequest()

xmlHttp.onreadystatechange = function(){
	
	if (this.readyState == 4 && this.status == 200) {
       // Typical action to be performed when the document is ready:
		
		const resposta = JSON.parse(xmlHttp.responseText)
	
		let table = document.createElement("table")
		table.classList.add("table")
		let tr = document.createElement("tr")
		let th1 = document.createElement("th")
		th1.appendChild(document.createTextNode("Código"))
		let th2 = document.createElement("th")
		th2.appendChild(document.createTextNode("Código"))
		let th3 = document.createElement("th")
		th3.innerHTML = "Localidade"
		let th4 = document.createElement("th")
		th4.innerHTML = "Whatsapp"
		let th5 = document.createElement("th")
		th5.innerHTML = "e-mail"
		let th6 = document.createElement("th")
		th6.innerHTML = "operaçoes"
		
		tr.appendChild(th1)
		tr.appendChild(th2)
		tr.appendChild(th3)
		tr.appendChild(th4)
		tr.appendChild(th5)
		tr.appendChild(th6)
		table.appendChild(tr)
		
		resposta.forEach((el) => {
			
			let trr = document.createElement("tr")
			let thh1 = document.createElement("td")
			thh1.innerHTML = el.codigo
			let thh2 = document.createElement("td")
			thh2.innerHTML = el.nome
			let thh3 = document.createElement("th")
			thh3.innerHTML = el.localidade
			let thh4 = document.createElement("td")
			thh4.innerHTML = el.whatsapp
			let thh5 = document.createElement("td")
			thh5.innerHTML = el.email
			let thh6 = document.createElement("td")
			
			let button = document.createElement("button")
			button.addEventListener("click",prepararVisualizacao(el.codigo))
			button.appendChild(document.createTextNode("visualizar"))
			button.setAttribute("data-bs-toggle", "modal")
			button.setAttribute("data-bs-target", "#modalVisual")
			
			thh6.appendChild(button)
			
			trr.appendChild(thh1)
			trr.appendChild(thh2)
			trr.appendChild(thh3)
			trr.appendChild(thh4)
			trr.appendChild(thh5)
			trr.appendChild(thh6)
			table.appendChild(trr)
		})
		
		divTabela.appendChild(table)
	
	}
	
}

xmlHttp.open("Get",urlAPI)
xmlHttp.send()

document.querySelector("[submitter]")
	.addEventListener("submit",function(event){
		
		event.preventDefault()
		
		const obj = {}
		
		const form = new FormData(document.forms[0])
		
		form.forEach( (value,key) => {
			obj[key] = value
		})
		
		const response = fetch("http://localhost:8080/apostador",
			{
				method:"post",
				headers:{
					 'Accept': 'application/json',
					 'Content-Type': 'application/json'
				},
				body:JSON.stringify(obj)
			}
		)
		
		location.reload()
		
	
	})	
	
	function prepararVisualizacao(codigo){
		
		fetch("http://localhost:8080/apostador/"+codigo).then(response => response.json())
		.then(json => {
			document.getElementById("codigo").innerHTML = json.codigo
			document.getElementById("nome").innerHTML = json.nome
		})
		
	}