console.log(document.documentElement); 
console.log(document.head);
console.log(document.body);

let nodePare = document.body;
console.log(document.children);
let primerFill = nodePare.firstElementChild;
console.log(primerFill);
console.log(primerFill.nodeType);
console.log(primerFill.nodeName); 
let element = document.getElementById("paragraf");
console.log(element);




function change_color(color){
    if(color == 1){element.style.color = "blue";}
    else{element.style.color = "red";}
    return false;
}


let boton_activado = false
let NoGordas = document.getElementById("rotated");
let rotation = 0;
const angle = 1;
let interval = null;
function boton_activo(){
    if (!boton_activado){
        boton_activado = true;
        interval = setInterval(rotate, 10);
    }
    else{
        boton_activado = false;
        clearInterval(interval);
    }
}

function rotate(){
    rotation = (rotation+angle)%360;
    NoGordas.style.transform = `rotate(${rotation}deg)`;
    return false;
}
    