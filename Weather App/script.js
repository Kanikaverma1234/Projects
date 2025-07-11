async function getWeather() {
    const city = document.getElementById('city').value.trim();
    const apiKey = '0d6a30b0d54c9d34cf854811c9976d39';

    if (!city) {
        document.getElementById('weather-info').innerHTML = `<p>Please enter a city name.</p>`;
        return;
    }

    const url = `https://api.openweathermap.org/data/2.5/weather?q=${city}&appid=${apiKey}&units=metric`;
    try {
        const response = await fetch(url);
        const data = await response.json();

        if (data.cod === 200) {
            document.getElementById('weather-info').innerHTML = `
                <p><strong>City:</strong> ${data.name}</p>
                <p><strong>Temperature:</strong> ${data.main.temp} °C</p>
                <p><strong>Condition:</strong> ${data.weather[0].description}</p>
            `;
        } else {
            document.getElementById('weather-info').innerHTML = `<p>City not found. Please check the spelling.</p>`;
        }
    } catch (error) {
        document.getElementById('weather-info').innerHTML = `<p>Something went wrong. Please try again later.</p>`;
        console.error(error);
    }
}
