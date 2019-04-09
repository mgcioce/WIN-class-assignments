var woolOwners = [
    {
        "master": 1
    },
    {
        "dame": 1
    },
    {
      "little boy": 1,
      "location": "down the lane"
    }
  ];
  
  var haveYouAnyWool = function(woolOwners) {
    let totalBags = 0;
    woolOwners.forEach((owner) => {
        let keyList = Object.keys(owner);
        keyList.forEach((key) => {
            if (typeof owner[key] === 'number') {
                totalBags = totalBags + owner[key];
            }
        })
    });
    return totalBags;
  };
  var bags = haveYouAnyWool(woolOwners);
  //console.log(bags);
  
  
  
  function baabaaBlackSheep() {
      console.log("BaaBaa BlackSheep have you any wool?");
      if (bags > 0) {
          console.log("yes sir, yes sir " + bags + " bags full");
    }
  }
  
  function oneForMy() {
      for (var i = 0; i < 2; i++) {
          people = Object.keys(woolOwners[i]);
          var person = people[0];
          console.log("one for my " + person);
      }
  }
  
  baabaaBlackSheep();
  oneForMy();
  
  var boy = Object.keys(woolOwners[2]);
  var littleBoy = boy[0];
  
  var whereHeLives = woolOwners[2][boy[1]];
  console.log("one for the " + littleBoy + " that lives " + whereHeLives);