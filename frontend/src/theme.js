import { createTheme } from '@mui/material/styles';

const theme = createTheme({
    palette: {
        primary: {
            main: '#26a69a', // Customizes the primary color
        },
        secondary: {
            main: '#ffe0b2', // Customizes the secondary color
        },
    },
    typography: {
        fontFamily: 'Comfortaa, Arial, sans-serif',
        h6: {
            fontWeight: 600,
        },
    },
});

// const theme = createTheme({
//     palette: {
//         primary: {
//             main: '#4CAF50', // Green primary color
//         },
//         secondary: {
//             main: '#F06292', // Pink secondary color
//         },
//         background: {
//             default: '#FAFAFA', // Light gray background
//         },
//     },
//     typography: {
//         fontFamily: 'Comfortaa, Arial, sans-serif',
//     },
// });

export default theme;





