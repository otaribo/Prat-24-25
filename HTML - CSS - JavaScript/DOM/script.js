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