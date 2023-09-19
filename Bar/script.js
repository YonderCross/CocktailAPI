console.log("JS7 apifetch");

function getDrinkByName() {
    fetch(`http://localhost:8080/drinks`)
        .then((response) => response.json())
        .then((drinks) => {
            console.log(drinks);

            let table = document.getElementById("tBody");
            tBody.innerHTML = "";

            for (let drink of drinks.drinks) {
                table.innerHTML += `
            <tr>
            <td>${drink.idDrink}</td>
            <td>${drink.strDrink}</td>
            <td>${drink.strCategory}</td>
            <td>
                <ol>
                    <li>${drink.strIngredient1}</li>
                    <li>${drink.strIngredient2}</li>
                    <li>${drink.strIngredient3}</li>
                    <li>${drink.strIngredient4}</li>
                    <li>${drink.strIngredient5}</li>
                    <li>${drink.strIngredient6}</li>

                </ol>
            </td>
            <td>
            <ol>
                <li>${drink.strMeasure1}</li>
                <li>${drink.strMeasure2}</li>
                <li>${drink.strMeasure3}</li>
                <li>${drink.strMeasure4}</li>
                <li>${drink.strMeasure5}</li>
                <li>${drink.strMeasure6}</li>

            </ol>
            </td>
            <td>${drink.strInstructions}</td>
            <td><img src="${drink.strDrinkThumb}" class="rounded-circle" style="width: 100px"></td>
          </tr> `
            }
        })
        .catch((error) => {
            console.error("Error: ", error);
            alerta(error);
        })
}

function getDrinkByIngredient(ingredient) {
    fetch(`http://localhost:8080/ingredients/vodka`)
        .then((response) => response.json())
        .then((ingredients) => {
            console.log(ingredients);

            let table = document.getElementById("tBody");
            tBody.innerHTML = "";

            for (let ingredient of ingredients.drinks) {
                table.innerHTML += `
            <tr>
            <td>${ingredient.idDrink}</td>
            <td>${ingredient.strDrink}</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td><img src="${ingredient.strDrinkThumb}" class="rounded-circle" style="width: 100px"></td>
          </tr> `
            }
        })
        .catch((error) => {
            console.error("Error: ", error);
            alerta(error);
        })
}