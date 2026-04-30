document.addEventListener("DOMContentLoaded", () => {
  fetch("http://localhost:8080/api/detalles-venta")
    .then(res => res.json())
    .then(data => renderDetalles(data));
});

function renderDetalles(data) {
  const contenedor = document.querySelector(".main-content");

  contenedor.innerHTML = data.map(d => `
    <div class="card mb-3">
      <div class="card-body">
        <h4>Detalle ${d.idDetalleVenta}</h4>
        <p>Precio: S/. ${d.precioUnitario}</p>
      </div>
    </div>
  `).join("");
}