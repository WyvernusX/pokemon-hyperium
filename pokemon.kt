import kotlin.random.Random
//TODO: change type, status, and other stringy things to an ENUM NOWWWW

class Location(var name: String, var type: String, var up: Location?, var down: Location?, var left: Location?, var right: Location?) {
    
}

class Pokemon(var name: String, var hp: Int, var level: Int, var type: HashSet<String>, var pokemonMoves: Moveset, var pokemonStats: Stats, var pokemonState: String) { 

  fun takeDamage(damage: Int) {
    this.hp = hp 
    if (hp - damage <= 0) {
      doFaint() 
    } else {
      hp -= damage
    }  
  }   

  fun checkState(stat: String) {
    
  }

  fun doFaint() {
    this.pokemonState = pokemonState
    pokemonState = "faint"
  } 

  fun enterHyper() {
    this.hp = hp 
    this.pokemonState = pokemonState
    pokemonState = "hyper"
    //set hp to half here 
  }

  fun enterUltima() {
    this.pokemonState = pokemonState
    pokemonState = "ultima"
  }

}

class Move(var name: String, var damage: Int, var type: String, var damageType: String, var accuracy: Int, var pp: Int) {
  
  fun useMove(target: Pokemon, origin: Pokemon) {
    this.damageType = damageType
    this.damage = damage 
    this.type = type 
    var finalDamage: Int = 0; 
    if (damageType != "special") {
      if (damageType == "spAttack") {
        finalDamage = ((((origin.level * 2 / 5) + 2 * damage * (origin.pokemonStats.spDamageStat / target.pokemonStats.spDefenseStat)) / 50) + 2)   
      } else if (damageType == "attack") {
        finalDamage = ((((origin.level * 2 / 5) + 2 * damage * (origin.pokemonStats.damageStat / target.pokemonStats.defenseStat)) / 50) + 2)  
      }
       
      if (type in origin.type) {
        finalDamage = (finalDamage * 1.5).toInt() 
      }
      //TODO: check crit and check types
      target.takeDamage(finalDamage) 
    } else if (damageType == "special") {
      //do the stat buff lmao
    }   
  }

}

class Moveset(var move1: Move, var move2: Move, var move3: Move, var move4: Move) {
   
  val movePool = hashSetOf<Move>(move1, move2, move3, move4) 
  
  fun forget(move: Move) { 
    if (move in movePool) {
      movePool.remove(move) 
    } 
  }

  fun learn(move: Move) { 
    if (move !in movePool && movePool.size > 4) {
      movePool.add(move) 
    }
  }
} 

class Stats(var hpStat: Int, var damageStat: Int, var defenseStat: Int, var spDamageStat: Int, var spDefenseStat: Int, var speedStat: Int) {
 
  val permStats: Array<Int> = arrayOf<Int>(hpStat, damageStat, defenseStat, spDamageStat, spDefenseStat, speedStat) 

  fun resetStats() {
    this.hpStat = hpStat  
    this.damageStat = damageStat 
    this.defenseStat = defenseStat 
    this.spDamageStat = spDamageStat 
    this.spDefenseStat = spDefenseStat 
    this.speedStat = speedStat 
   
    hpStat = permStats[0]
    damageStat = permStats[1] 
    defenseStat = permStats[2]
    spDamageStat = permStats[3]
    spDefenseStat = permStats[4]
    speedStat = permStats[5]
  } 

  fun statBuff(name: String, amount: Int) {
    this.hpStat = hpStat
    this.damageStat = damageStat
    this.defenseStat = defenseStat
    this.spDamageStat = spDamageStat
    this.spDefenseStat = spDefenseStat
    this.speedStat = speedStat 
  
    if (name == "hp") {
      hpStat += amount 
    } else if (name == "damage") {
      damageStat += amount
    } else if (name == "defense") {
      defenseStat += amount
    } else if (name == "specialDamage") {
      spDamageStat += amount
    } else if (name == "specialDefense") {
      spDefenseStat += amount   
    } else if (name == "speed") {
      speedStat += amount
    } 
  }  

  /* fun tempStatBuff(name: String, amount: Int) {
    this.hpStat = hpStat
    this.damageStat = damageStat
    this.defenseStat = defenseStat
    this.spDamageStat = spDamageStat
    this.spDefenseStat = spDefenseStat
    this.speedStat = speedStat

    if (name == "hp") {

    } else if (name == "damage") {

    } else if (name == "defense") {

    } else if (name == "specialDamage") {

    } else if (name == "specialDefense") {

    } else if (name == "speed") {

    }
  }

  fun tempStatDebuff() {

  }*/
} 

class Player(var name: String, var badges: Int, var money: Int, var pokemonLineup: Array<Pokemon>, var playerInventory: Inventory) {

}

class Inventory() { 
  val inventoryMap = mutableMapOf<String, Int>()   

  fun isIn(name: String): Boolean { 
    return name in inventoryMap
  }

  fun add(name: String) {
   
  }

  fun remove(name: String) {

  }

}

class Enemy(var name: String, var pokemonLineup: Array<Pokemon>) {
  
}

fun main() { 
  println("citykeys")
}
