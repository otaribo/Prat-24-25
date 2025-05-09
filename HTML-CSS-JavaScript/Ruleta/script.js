const canvas = document.getElementById("ruleta");
const ctx = canvas.getContext("2d");
const size = canvas.width;
const center = size / 2;
const radius = size / 2 - 10; // Margen pequeño
let posiciones = 100; // Número inicial de posiciones
let anguloPorSegmento = (2 * Math.PI) / posiciones;

// Estructura de datos para las casillas
let casillas = Array.from({ length: posiciones }, (_, i) => ({
  id: i + 1,
  texto: (i + 1).toString(),
  activa: true,
}));

// Función para dibujar la flecha
function dibujarFlecha() {
  ctx.fillStyle = "#00ff00"; // Color verde
  ctx.beginPath();
  ctx.moveTo(center - 10, 20); // Punto izquierdo de la flecha
  ctx.lineTo(center + 10, 20); // Punto derecho de la flecha
  ctx.lineTo(center, 40); // Punta de la flecha
  ctx.closePath();
  ctx.fill();
}

// Función para actualizar el número de posiciones
function actualizarPosiciones(nuevasPosiciones) {
  posiciones = nuevasPosiciones;
  anguloPorSegmento = (2 * Math.PI) / posiciones;
  casillas = Array.from({ length: posiciones }, (_, i) => ({
    id: i + 1,
    texto: (i + 1).toString(),
    activa: true,
  }));
  dibujarRuleta(); // Redibujar la ruleta con las nuevas posiciones
}

// Dibujar la ruleta
function dibujarRuleta() {
  ctx.clearRect(0, 0, size, size); // Limpiar el canvas antes de redibujar
  casillas.forEach((casilla, i) => {
    if (!casilla.activa) return; // Saltar casillas inactivas

    const anguloInicio = i * anguloPorSegmento;
    const anguloFin = anguloInicio + anguloPorSegmento;

    // Alternar colores
    ctx.fillStyle = i % 2 === 0 ? "#ffcc00" : "#ff5733";

    // Dibujar un segmento
    ctx.beginPath();
    ctx.moveTo(center, center);
    ctx.arc(center, center, radius, anguloInicio, anguloFin);
    ctx.closePath();
    ctx.fill();

    // Añadir texto
    ctx.save();
    ctx.translate(center, center);
    ctx.rotate(anguloInicio + anguloPorSegmento / 2);
    ctx.textAlign = "right";
    ctx.fillStyle = "#000";
    ctx.font = "12px Arial";
    ctx.fillText(casilla.texto, radius - 20, 5); // Usar el texto de la casilla
    ctx.restore();
  });
}

// Animar la ruleta
let anguloActual = 0;
let velocidad = 0;
let girando = false;

function girarRuleta() {
  if (girando) {
    anguloActual += velocidad;
    velocidad *= 0.98; // Reducir la velocidad gradualmente

    // Detener la ruleta si la velocidad es muy baja
    if (velocidad < 0.01) {
      girando = false;

      // Calcular la posición final debajo de la flecha
      const anguloNormalizado = anguloActual % (2 * Math.PI); // Normalizar el ángulo
      const posicionFinal = Math.floor((anguloNormalizado / anguloPorSegmento)) % posiciones;

      // Mostrar el resultado
      alert(`¡Resultado: ${casillas[posicionFinal].texto}!`);
    }
  }

  // Dibujar ruleta rotada
  ctx.clearRect(0, 0, size, size);
  ctx.save();
  ctx.translate(center, center);
  ctx.rotate(anguloActual);
  ctx.translate(-center, -center);
  dibujarRuleta();
  ctx.restore();

  // Dibujar la flecha fija
  dibujarFlecha();

  if (girando) {
    requestAnimationFrame(girarRuleta); // Continuar la animación
  }
}

// Configurar botón de giro
document.getElementById("spin-button").addEventListener("click", () => {
  if (!girando) {
    velocidad = Math.random() * 0.3 + 0.2; // Velocidad inicial aleatoria
    girando = true;
    girarRuleta(); // Iniciar la animación
  }
});

// Configurar botón para actualizar posiciones
document.getElementById("actualizar-posiciones").addEventListener("click", () => {
  const nuevasPosiciones = parseInt(document.getElementById("posiciones-input").value);
  if (nuevasPosiciones > 0) {
    actualizarPosiciones(nuevasPosiciones);
  } else {
    alert("Por favor, ingresa un número válido de posiciones.");
  }
});

// Modal para editar casillas
const editModal = document.getElementById("edit-modal");
const casillaIdInput = document.getElementById("casilla-id");
const casillaTextoInput = document.getElementById("casilla-texto");

document.getElementById("edit-button").addEventListener("click", () => {
  editModal.style.display = "block";
});

document.getElementById("cerrar-modal").addEventListener("click", () => {
  editModal.style.display = "none";
});

document.getElementById("guardar-cambios").addEventListener("click", () => {
  const id = parseInt(casillaIdInput.value) - 1; // Convertir a índice
  const texto = casillaTextoInput.value;

  if (id >= 0 && id < casillas.length) {
    casillas[id].texto = texto;
    dibujarRuleta(); // Redibujar la ruleta
    editModal.style.display = "none";
  } else {
    alert("Número de casilla inválido.");
  }
});

document.getElementById("eliminar-casilla").addEventListener("click", () => {
  const id = parseInt(casillaIdInput.value) - 1; // Convertir a índice

  if (id >= 0 && id < casillas.length) {
    casillas[id].activa = false;
    dibujarRuleta(); // Redibujar la ruleta
    editModal.style.display = "none";
  } else {
    alert("Número de casilla inválido.");
  }
});

// Dibujar la ruleta inicial
dibujarRuleta();
dibujarFlecha(); // Dibujar la flecha inicial