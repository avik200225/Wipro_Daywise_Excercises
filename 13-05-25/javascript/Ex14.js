const cities = ["Mumbai", "Delhi", "Kolkata", "Chennai", "Pune", "Bengaluru", "Ahmedabad"];

document.getElementById("loadCities").addEventListener("click", () => {
    const dropdown = document.getElementById("cityDropdown");
    dropdown.length = 1;

    const sortedCities = cities.sort();

    sortedCities.forEach(city => {
        const option = document.createElement("option");
        option.value = city;
        option.textContent = city;
        dropdown.appendChild(option);
    });
});
