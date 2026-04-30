document.addEventListener("DOMContentLoaded", () => {
  fetch("http://localhost:8080/api/productos")
    .then(res => res.json())
    .then(data => renderProductos(data));
});

function renderProductos(data) {
  const contenedor = document.querySelector(".main-content");

  contenedor.innerHTML = data.map(p => `
    <div class="card mb-3">
      <div class="card-body">
        <h4>${p.nombreProducto}</h4>
        <p>Precio: S/. ${p.precioUnitario}</p>
        <p>Stock: ${p.stock}</p>
      </div>
    </div>
  `).join("");
}