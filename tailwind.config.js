/** @type {import('tailwindcss').Config} */
module.exports = {
    content: ['./src/main/resources/templates/**/*.html'],
    theme: {
        extend: {
            fontFamily: {
                'base': ['Roboto', 'sans-serif'],
                'header': ['Orbitron', 'sans-serif'],
            }
        },
    },
    plugins: [require('daisyui')],
    daisyui: {
        themes: ["fantasy", "forest", "cyberpunk"],
    },
}

