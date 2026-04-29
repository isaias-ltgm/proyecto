/* ================================================
   Bodeguita de Don Pepito — Scripts (main.js)
   ================================================ */

// ── FECHA EN ESPAÑOL ──
(function mostrarFecha() {
  var dias   = ['domingo','lunes','martes','miércoles','jueves','viernes','sábado'];
  var meses  = ['enero','febrero','marzo','abril','mayo','junio','julio',
                'agosto','septiembre','octubre','noviembre','diciembre'];
  var hoy    = new Date();
  var elem   = document.getElementById('fecha-hoy');
  if (elem) {
    elem.textContent =
      'Resumen del día — ' +
      dias[hoy.getDay()] + ' ' +
      hoy.getDate() + ' de ' +
      meses[hoy.getMonth()];
  }
})();


// ── NAVEGACIÓN ACTIVA ──
/**
 * Marca como activo el ítem del menú que fue pulsado
 * y desactiva los demás.
 * @param {HTMLElement} el - Elemento .nav-item clickeado
 */
function setActive(el) {
  document.querySelectorAll('.nav-item').forEach(function(item) {
    item.classList.remove('active');
  });
  el.classList.add('active');
}


// ── GRÁFICO DE BARRAS (página Inicio) ──
(function renderBarras() {
  var area = document.getElementById('barsArea');
  if (!area) return; // Solo ejecutar si existe el contenedor

  var datos = [
    { turno: 'Mañana',   monto: 320,  opacidad: 1.0  },
    { turno: 'Mediodía', monto: 560,  opacidad: 1.0  },
    { turno: 'Tarde',    monto: 240,  opacidad: 0.6  },
    { turno: 'Noche',    monto: 120,  opacidad: 0.35 }
  ];

  var maxMonto  = Math.max.apply(null, datos.map(function(d) { return d.monto; }));
  var alturaMax = 170; // px

  datos.forEach(function(d, i) {
    var altura = Math.round((d.monto / maxMonto) * alturaMax);

    // Columna
    var col = document.createElement('div');
    col.className = 'bar-col';

    // Valor numérico encima de la barra
    var val = document.createElement('div');
    val.className = 'bar-val';
    val.textContent = 'S/' + d.monto;

    // Barra (comienza en 0, anima al alto real)
    var bar = document.createElement('div');
    bar.className = 'bar-fill';
    bar.style.cssText =
      'height:0px;' +
      'background:#e8392a;' +
      'opacity:' + d.opacidad + ';' +
      'transition: height 0.6s cubic-bezier(.22,1,.36,1) ' + (i * 0.08) + 's;';

    col.appendChild(val);
    col.appendChild(bar);
    area.appendChild(col);

    // Disparar animación después de que el DOM esté listo
    setTimeout(function() {
      bar.style.height = altura + 'px';
    }, 100);
  });
})();
