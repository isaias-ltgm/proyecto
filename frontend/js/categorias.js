document.addEventListener("DOMContentLoaded", () => {

  fetch("http://localhost:8080/api/categorias")
    .then(res => res.json())
    .then(data => {
      const contenedor = document.querySelector(".main-content");

      contenedor.innerHTML = data.map(cat => `
        <div class="card mb-3 shadow-sm">
          <div class="card-body">
            <h4 class="card-title">${cat.nombre}</h4>
            <p class="card-text">${cat.descricion}</p>

            <h6>Productos:</h6>
            ${cat.productos && cat.productos.length > 0 
              ? cat.productos.map(prod => `
                <div class="border p-2 mb-2 rounded">
                  <strong>${prod.nombreProducto}</strong><br>
                  Precio: S/. ${prod.precioUnitario}<br>
                  Stock: ${prod.stock}
                </div>
              `).join("")
              : "<p>No hay productos</p>"
            }

          </div>
        </div>
      `).join("");

    })
    .catch(err => {
      console.error(err);
      document.querySelector(".main-content").innerHTML =
        "<p>Error al cargar datos</p>";
    });

});