
import React from 'react';
import { Typography, Container } from '@mui/material';
import {  makeStyles } from '@mui/styles';


const useStyles = makeStyles((theme) => ({
    footer: {
        backgroundColor: theme.palette.primary.main,
        padding: theme.spacing(3, 0),
        color: theme.palette.common.white,
    },
}));

function Footer() {
    const classes = useStyles();

    return (
        <footer className={classes.footer}>
            <Container maxWidth="lg">
                <Typography variant="body2" align="center">
                    © {new Date().getFullYear()} Botanica Virtual Garden
                </Typography>
            </Container>
        </footer>
    );
}

export default Footer;




// const Footer = () => {
//     return (
//         <Container component="footer" sx={{ mt: 5 }}>
//             <Typography variant="body2" color="textSecondary" align="center">
//                 &copy; {new Date().getFullYear()} Botanica Virtual Garden
//             </Typography>
//         </Container>
//     );
// };
//
// export default Footer;
