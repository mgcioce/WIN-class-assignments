function doubleAll(numbers) {
    var result = []
    for (var i = 0; i < numbers.length; i++) {
      result.push(numbers[i] * 2)
    }
    result = numbers.map( (k) => {
        return k * 2;
    })
    return result
  }
  
  module.exports = doubleAll
