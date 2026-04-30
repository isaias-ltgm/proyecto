document.addEventListener("DOMContentLoaded", () => {
  fetch("http://localhost:8080/api/ventas")
    .then(res => res.json())
    .then(data => renderVentas(data));
});

function renderVentas(data) {
  const contenedor = document.querySelector(".main-content");

  contenedor.innerHTML = data.map(v => `
    <div class="card mb-3">
      <div class="card-body">
        <h4>Venta ${v.idVenta}</h4>
        <p>Total: S/. ${v.totalVenta}</p>

        ${v.detalles?.map(d => `
          <div class="border p-2 mt-2">
            Detalle: ${d.idDetalleVenta} - S/. ${d.precioUnitario}
          </div>
        `).join("") || ""}
      </div>
    </div>
  `).join("");
}