

const divTabela = document.querySelector("[tabela]")
const urlAPI = divTabela.getAttribute("tabela")

fetch(urlAPI).then(response => response.json())
.then(json => {

    const table = document.createElement("table")
    table.classList.add("table")
    const tr = document.createElement("tr")
    const th1 = document.createElement("th")
    th1.appendChild(document.createTextNode("código"))
    const th2 = document.createElement("th")
    th2.appendChild(document.createTextNode("Data de Criação"))
    const th3 = document.createElement("th")
    th3.appendChild(document.createTextNode("Valor Aposta"))
    const th4 = document.createElement("th")
    th4.appendChild(document.createTextNode("Número de Apostas"))
    const th5 = document.createElement("th")
    th5.appendChild(document.createTextNode("Quantidade de Aposta"))
    const th6 = document.createElement("th")
    th6.appendChild(document.createTextNode("Status"))

    table.appendChild(tr)
    tr.appendChild(th1)
    tr.appendChild(th2)
    tr.appendChild(th3)
    tr.appendChild(th4)
    tr.appendChild(th5)
    tr.appendChild(th6)

    json.forEach(el => {
        
        const trr = document.createElement("tr")
        const thh1 = document.createElement("td")
        thh1.appendChild(document.createTextNode(el.codigo))
        const thh2 = document.createElement("td")
        thh2.appendChild(document.createTextNode(el.dataCriacao))
        const thh3 = document.createElement("td")
        thh3.appendChild(document.createTextNode(el.valorAposta))
        const thh4 = document.createElement("td")
        thh4.appendChild(document.createTextNode(el.quantNumeros))
        const thh5 = document.createElement("td")
        thh5.appendChild(document.createTextNode(el.apostas.length))
        const thh6 = document.createElement("td")
        thh6.appendChild(document.createTextNode(el.status))
        
        table.appendChild(trr)
        trr.appendChild(thh1)
        trr.appendChild(thh2)
        trr.appendChild(thh3)
        trr.appendChild(thh4)
        trr.appendChild(thh5)
        trr.appendChild(thh6)
    });

    divTabela.append(table)

})

