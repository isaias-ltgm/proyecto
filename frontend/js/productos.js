const API = "http://localhost:8080/api/productos";

// instancia reutilizable del modal
let modalBS = null;

document.addEventListener("DOMContentLoaded", () => {
  modalBS = new bootstrap.Modal(document.getElementById("modalProducto"));

  // limpiar formulario cada vez que el modal se cierra
  document.getElementById("modalProducto").addEventListener("hidden.bs.modal", limpiarFormulario);

  cargarProductos();
});

// ================== ABRIR MODAL NUEVO ==================
function abrirModalNuevo() {
  limpiarFormulario();
  modalBS.show();
}

// ================== CARGAR ==================
function cargarProductos() {
  fetch(API)
    .then(res => {
      if (!res.ok) throw new Error("Error al obtener productos");
      return res.json();
    })
    .then(data => renderProductos(data))
    .catch(err => {
      console.error("Error:", err);
      document.getElementById("lista-productos").innerHTML = `
        <div class="col-12">
          <div class="alert alert-danger">
            <i class="fa-solid fa-triangle-exclamation"></i>
            No se pudo conectar a la API. ¿Está corriendo Spring Boot?
          </div>
        </div>`;
    });
}
