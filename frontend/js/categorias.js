document.addEventListener("DOMContentLoaded", () => {
  cargarCategorias();
});

// ================== GET ==================
function cargarCategorias() {
  fetch("http://localhost:8080/api/categorias")
    .then(res => res.json())
    .then(data => renderCategorias(data));
}

// ================== RENDER ==================
function renderCategorias(data) {
  const contenedor = document.getElementById("lista-categorias");

  contenedor.innerHTML = data.map(c => `
    <div class="card mb-3 shadow-sm">
      <div class="card-body">

        <h5>
          <i class="fa-solid fa-folder"></i> ${c.nombre}
        </h5>

        <p>${c.descricion}</p>

        <button class="btn btn-warning btn-sm"
          onclick="editarCategoria(${c.idCategoria})">
          <i class="fa-solid fa-pen"></i>
        </button>

        <button class="btn btn-danger btn-sm"
          onclick="eliminarCategoria(${c.idCategoria})">
          <i class="fa-solid fa-trash"></i>
        </button>

      </div>
    </div>
  `).join("");
}

// ================== LIMPIAR ==================
function limpiarFormularioCategoria() {
  document.getElementById("idCategoria").value = "";
  document.getElementById("nombreCat").value = "";
  document.getElementById("descCat").value = "";

  document.getElementById("titulo-cat").innerHTML =
    `<i class="fa-solid fa-clipboard-list"></i> Nueva Categoría`;
}

// ================== GUARDAR ==================
function guardarCategoria() {
  const id = document.getElementById("idCategoria").value;

  const categoria = {
    nombre: document.getElementById("nombreCat").value,
    descricion: document.getElementById("descCat").value
  };

  const url = id
    ? `http://localhost:8080/api/categorias/${id}`
    : "http://localhost:8080/api/categorias";

  const metodo = id ? "PUT" : "POST";

  fetch(url, {
    method: metodo,
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(categoria)
  })
    .then(res => {
      if (!res.ok) throw new Error("Error al guardar");
      return res.json();
    })
    .then(() => {
      const modal = bootstrap.Modal.getInstance(document.getElementById("modalCategoria"));
      modal.hide();

      cargarCategorias();
    })
    .catch(err => console.error(err));
}

// ================== EDITAR ==================
function editarCategoria(id) {
  fetch(`http://localhost:8080/api/categorias/${id}`)
    .then(res => res.json())
    .then(c => {
      document.getElementById("idCategoria").value = c.idCategoria;
      document.getElementById("nombreCat").value = c.nombre;
      document.getElementById("descCat").value = c.descricion;

      document.getElementById("titulo-cat").innerHTML =
        `<i class="fa-solid fa-pen"></i> Editar Categoría`;

      const modal = new bootstrap.Modal(document.getElementById("modalCategoria"));
      modal.show();
    });
}

// ================== ELIMINAR ==================
function eliminarCategoria(id) {
  if (confirm("¿Eliminar categoría?")) {
    fetch(`http://localhost:8080/api/categorias/${id}`, {
      method: "DELETE"
    })
    .then(() => cargarCategorias());
  }
}