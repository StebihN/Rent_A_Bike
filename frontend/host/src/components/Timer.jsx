import { useEffect, useState, useRef } from 'react';

import { Stack, Typography } from '@mui/material';
import RouteOutlinedIcon from '@mui/icons-material/RouteOutlined';

import Cookies from 'js-cookie'

export default function Timer({rentedOn}) {
    const [timer, setTimer] = useState(0)
    const [isRunning, setIsRunning] = useState(false)

    let timeInterval = useRef(null);

    useEffect(() => {
        setTimer((Date.now() - rentedOn) / 1000)
        startTimer()
    }, [])

    const startTimer = () => {
        if (isRunning) return
        setIsRunning(true)
        timeInterval.current = setInterval(() => {
            setTimer((prev) => prev + 1)
        }, 1000)
    }

    const resetTimer = () => {
        setIsRunning(false)
    }

    const formatTime = (timer) => {
        const minutes = Math.floor(timer / 60)
            .toString()
            .padStart(2, "0");
        const seconds = Math.floor((timer % 60))
            .toString()
            .padStart(2, "0");
        return { minutes, seconds };
    };

    const { minutes, seconds } = formatTime(timer)
    return (
        <Typography color={"white"} letterSpacing={1} >{minutes}:{seconds}</Typography>
    )
}