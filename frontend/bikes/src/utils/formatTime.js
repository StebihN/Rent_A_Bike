export const formatTime = (time) => {
    const inSeconds = time / 1000
    const minutes = Math.floor(inSeconds / 60)
        .toString()
        .padStart(2, "0");
    const seconds = Math.floor(inSeconds % 60)
        .toString()
        .padStart(2, "0");
    return { minutes, seconds };
}