// Copyright 2020 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

/** Adds a random fact to the page. */
function addRandomFact() {
    const facts = 
        ['Tech Guy', 'Hiking', 'Travel', 'Aerospace', 'Netflix'];
    
    // Pick a random fact.
    const fact = facts[Math.floor(Math.random() * facts.length)];

    // Add it to the page.
    const factContainer = document.getElementById('fact-container');
    factContainer.innerText = fact;
}

/** Fetches the current date from the server and adds it to the page. */
async function showServerTime() {
    const responseFromServer = await fetch('/date');
    const textFromResponse = await responseFromServer.text();
  
    const dateContainer = document.getElementById('date-container');
    dateContainer.innerText = textFromResponse;
}

/** Adds random quotes to the html page. */
async function printString() {
    const getResponseFromServer = await fetch('/quotes');
    const jsonFromResponse = await getResponseFromServer.json();
    console.log(jsonFromResponse);

    const stringContainer = document.getElementById('life-quote-container');
    stringContainer.innerHTML = getRandomQuote(jsonFromResponse);
}

/** Gets random quote from server. */
function getRandomQuote(jsonFromResponse) {
    const randomIndex = Math.floor(Math.random() * jsonFromResponse.quotes.length);
    const randomQuote = jsonFromResponse.quotes[randomIndex];
    return randomQuote;
}