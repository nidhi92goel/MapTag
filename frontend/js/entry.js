function getTrends(place, successCallback) {
  successCallback(["hashtag1", "hashtag2"])
  // fetch('flowers.jpg').then(function(response) {
  //   return response.blob();
  // }).then(function(results, status) {
  //     if (status === "OK") {
  //       successCallback(results)
  //     } else {
  //       alert("error")
  //     }
  // })
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

   newtrends.forEach(function(divTrend) {
     feed.appendChild(divTrend)
   })
 })

// var divList = []
// for (var i = 0; i < trends.length; i++) {
//   var trend = trends[i]
//   var div = document.createElement("div");
//  div.style.width = "100px";
//  div.style.height = "100px";
//  div.style.background = "red";
//  div.style.color = "white";
//  div.innerHTML = trend;
//  divList.push(div);
// }

 // console.log(trends)
});
