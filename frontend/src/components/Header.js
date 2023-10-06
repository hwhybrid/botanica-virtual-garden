import React from 'react';
import { AppBar, Toolbar, Typography, Button} from '@mui/material';
import {  makeStyles } from '@mui/styles';

import { Link } from 'react-router-dom';

const useStyles = makeStyles((theme) => ({
    appBar: {
        backgroundColor: theme.palette.primary.main,
    },
    title: {
        flexGrow: 1,
        fontWeight: 'bold',
    },
    link: {
        textDecoration: 'none',
        color: 'inherit',
        margin: theme.spacing(1, 2),
    },
}));

function Header() {
    const classes = useStyles();

    return (
        <AppBar position="static" className={classes.appBar}>
            <Toolbar>
                <Typography variant="h6" className={classes.title}>
                    Botanica Virtual Garden
                </Typography>
                <Link to="/" className={classes.link}>
                    <Button color="inherit">Home</Button>
                </Link>
                <Link to="/about" className={classes.link}>
                    <Button color="inherit">About</Button>
                </Link>
                <Link to="/contact" className={classes.link}>
                    <Button color="inherit">Contact</Button>
                </Link>
                <Link to="/carousel" className={classes.link}>
                    <Button color="inherit">Plant Carousel</Button>
                </Link>
                <Link to="/search" className={classes.link}>
                    <Button color="inherit">Search</Button>
                </Link>
            </Toolbar>
        </AppBar>
    );
}

export default Header;
