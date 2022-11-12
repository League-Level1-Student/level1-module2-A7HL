package _01_sea_creature;

public class SeaCreatureRunner {
	public static void main(String[] args) {
		SeaCreature Spongebob = new SeaCreature("Spongebob");
		System.out.println(Spongebob.getName());
		Spongebob.eat();
		Spongebob.laugh();
		
		SeaCreature Squidward = new SeaCreature("Squidward");
		System.out.println(Squidward.getName());
		Squidward.eat();
		Squidward.laugh();
		
		SeaCreature Patrick = new SeaCreature("Patrick");
		System.out.println(Patrick.getName());
		Patrick.eat();
		Patrick.laugh();
		
	}
}
