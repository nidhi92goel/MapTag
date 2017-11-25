function getTrends(place, successCallback) {
  fetch(`http://localhost:8080/?place=${place}`).then(function(response) {
    return response.json();
  }).then(function(results, status) {
    console.log(results)
    successCallback(results)
  }).catch(function(err) {
    console.log(err)
});
}

function loadMap() {
  var map = new GMaps({
    el: '#map',
    lat: -12.043333,
    lng: -77.028333
  });
}

loadMap();

$("#button").click(function () {
 var search = $("#search-box").val()
 var trends = getTrends(search, function(results) {
   var newtrends = results.map(function(trend) {
     var div = document.createElement("div");
     div.className = "hashtag"

      div.innerHTML = trend;
      return div

   })
   //new trends is a list of div tags in which our hashtags reside
   console.log(newtrends)

   var feed = document.getElementById("feed")
   feed.innerHTML = ''
   newtrends.forEach(function(divTrend) {
     feed.appendChild(divTrend)
   })
 })
});
