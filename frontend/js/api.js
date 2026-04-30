const API_BASE = 'http://localhost:8080/api';

const API = {
    async get(endpoint) {
        const res = await fetch(`${API_BASE}${endpoint}`);
        if (!res.ok) throw new Error(`Error ${res.status}`);
        return res.json();
    },

    async post(endpoint, data) {
        const res = await fetch(`${API_BASE}${endpoint}`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(data)
        });
        if (!res.ok) throw new Error(`Error ${res.status}`);
        return res.json();
    },

    async put(endpoint, data) {
        const res = await fetch(`${API_BASE}${endpoint}`, {
            method: 'PUT',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(data)
        });
        if (!res.ok) throw new Error(`Error ${res.status}`);
        return res.json();
    },

    async delete(endpoint) {
        const res = await fetch(`${API_BASE}${endpoint}`, { method: 'DELETE' });
        if (!res.ok) throw new Error(`Error ${res.status}`);
        return res.status !== 204 ? res.json() : null;
    }
};

function mostrarAlerta(tipo, mensaje, containerId = 'alert-box') {
    const el = document.getElementById(containerId);
    if (!el) return;
    el.className = `alert alert-${tipo} show`;
    el.textContent = mensaje;
    setTimeout(() => el.classList.remove('show'), 3500);
}

function setNavActivo() {
    const actual = window.location.pathname.split('/').pop();
    document.querySelectorAll('.nav-link').forEach(link => {
        const href = link.getAttribute('href');
        link.classList.toggle('active', href === actual);
    });
}

document.addEventListener('DOMContentLoaded', setNavActivo);