---
config:
  theme: mc
  layout: dagre
---
classDiagram

class Main {
    +main(String[] args)$ void
    -initializeApplicationFrame()$ void
}

class Controller {
    - GameEnvironment gameEnv
    - View view
    - EventHandling eventHandling
    + start() void
    + handleMainMenu() void
    + handleLevelSelection() void
    + handleGameplay() void
}

class GameEnvironment {
    - Player player
    - List~Enemy~ enemies
    - List~Projectile~ projectiles
    - MapData mapData
    + update() void
}

class Player {
    - int hp
    - int defense
    - int atk
    - int stamina
    - int x, y
    - Weapon equippedWeapon
    + Player(int hp, int defense, int atk, int stamina)
    + move() void
    + attack() void
}

class Weapon {
    # int damage
    # int ammoCapacity
    + fire(int playerAtk) Projectile
}

class RifleSubclass {
    + fire(int playerAtk) Projectile
}

class SMGSubclass {
    + fire(int playerAtk) Projectile
}

class SniperSubclass {
    + fire(int playerAtk) Projectile
}

class ShotgunSubclass {
    + fire(int playerAtk) Projectile
}

class RocketSubclass {
    + fire(int playerAtk) Projectile
}

class RailgunSubclass {
    + fire(int playerAtk) Projectile
}

class Projectile {
    - int x, y
    - int velocityX, velocityY
    - int damage
    + Projectile(int x, int y, int vx, int vy, int damage)
    + update() void
    + getBounds() Rectangle
}

class Enemy {
    # int hp
    # int defense
    # int atk
    # int stamina
    + Enemy(int hp, int defense, int atk, int stamina)
    + attack() void
    + takeDamage(int amount) void
}

class Goblin {
    + attack() void
}

class Skeleton {
    + attack() void
}

class Spider {
    + attack() void
}

class Physics {
    <<utility>>
    + checkCollision(Rectangle r1, Rectangle r2)$ boolean
}

class GameMathComputation {
    <<utility>>
    + calculateDistance(int x1, int y1, int x2, int y2)$ double
}

class ApplicationFrame {
    + ApplicationFrame()
}

class View {
    + showMainMenu() void
    + showLevelSelection() void
    + showLevel(GameEnvironment env) void
    - showPlayerUI(Graphics g, Player player) void
}

class EventHandling {
    + handleInput() void
}

class ProjectData {
    - String config
}

%% Relationships
Main ..> Controller : creates
Controller --> GameEnvironment : controls
Controller --> View : invokes screens
ApplicationFrame <|-- View : extends
GameEnvironment *-- Player : contains
GameEnvironment *-- Enemy : contains multiple
GameEnvironment *-- Projectile : manages active
Player o-- Weapon : equips
Weapon ..> Projectile : spawns
Weapon <|-- RifleSubclass
Weapon <|-- SMGSubclass
Weapon <|-- SniperSubclass
Weapon <|-- ShotgunSubclass
Weapon <|-- RocketSubclass
Weapon <|-- RailgunSubclass
Enemy <|-- Goblin
Enemy <|-- Skeleton
Enemy <|-- Spider
GameEnvironment ..> Physics : uses
GameEnvironment ..> GameMathComputation : uses
Controller --> EventHandling : manages inputs
