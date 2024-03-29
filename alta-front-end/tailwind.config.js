/** @type {import('tailwindcss').Config} */
export default {
	content: ['./index.html', './src/**/*.{js,ts,jsx,tsx}'],
	important: "body",
	theme: {
		extend: {
			colors: {
				"green-primary": "#79aa2d"
			}
		},
	},
	plugins: [],
};
