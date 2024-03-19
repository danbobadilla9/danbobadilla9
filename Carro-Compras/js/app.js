//variables
const carrito = document.querySelector('#carrito');
const contenedorCarrito = document.querySelector('#lista-carrito tbody');
const vaciarCarritoBtn = document.querySelector('#vaciar-carrito');
const listaCursos = document.querySelector('#lista-cursos');
let articulosCarrito = [];


cargarEventListeners();
function cargarEventListeners(){
    // al dar click en agregar carrito 
    listaCursos.addEventListener('click',agregarCurso)
    // Elimina cursos del carrito
    carrito.addEventListener('click',eliminarCurso);

    // Vaciar el carrito
    vaciarCarritoBtn.addEventListener('click', () => {
        articulosCarrito = [];
        limpiarHTML();
    })
}

//Funciones
function agregarCurso(e) {
    e.preventDefault();
    console.log(e.target.classList);
    if(e.target.classList.contains('agregar-carrito')){
        console.log('Agregando');
        const cursoSeleccionado = e.target.parentElement.parentElement;
        leerDatosCurso(cursoSeleccionado)
    }
}

// elimina un curso del carrito
function eliminarCurso(e){
    if(e.target.classList.contains('borrar-curso')){
        const cursoId = e.target.getAttribute('data-id');
        // elimina del arreglo
        articulosCarrito = articulosCarrito.filter( curso => curso.id !== cursoId);
        carritoHTML();
    }
}


// Leer el contenido del HTML al que le dimos click y extraer la información del curso 

function leerDatosCurso(curso){
    // console.log(curso);

    // Crear un objeto con el contenido del curso actual 
    const infoCurso = {
        id: curso.querySelector('a').getAttribute('data-id'),
        imagen: curso.querySelector('img').src,
        titulo: curso.querySelector('h4').textContent,
        precio: curso.querySelector('.precio span').textContent,
        cantidad: 1
    }

    // revisa si un curso ya existe en el carrito
    const existe = articulosCarrito.some( curso => curso.id === infoCurso.id );
    if(existe){
        // actualizamos cantidad
        const cursos = articulosCarrito.map( curso => {
            if(curso.id === infoCurso.id){
                curso.cantidad++;
                return curso;
            }else{
                return curso;
            }
        } );
        articulosCarrito = [ ...cursos ]
    }else{
        // agrega elementos al arreglo de carrito
        articulosCarrito = [ ...articulosCarrito, infoCurso ]
    }
    carritoHTML();
}

// Muestra el carrito de compras en el html

function carritoHTML (){
    // limpiar el HTML
    limpiarHTML();
    // Recorre el carrito y genera el HTML
    articulosCarrito.forEach( curso => {
        const {imagen,titulo,precio,cantidad,id} = curso;
        const row =  document.createElement('tr');
        row.innerHTML = `
            <td>
                <img src="${imagen}" width="100"/>
            </td>
            <td>
                ${titulo}
            </td>
            <td>
                ${precio}
            </td>
            <td>
                ${cantidad}
            </td>
            <td>
                <a href="#" class="borrar-curso" data-id="${id}"> X </a>
            </td>
        `;

        // Agrega el html del carrito en el tbody
        contenedorCarrito.appendChild(row)
    })

}


// Elimina los cursos del tbody

function limpiarHTML () {
    // Forma lenta
    // contenedorCarrito.innerHTML='';
    while(contenedorCarrito.firstChild){
        contenedorCarrito.removeChild(contenedorCarrito.firstChild)
    }
}