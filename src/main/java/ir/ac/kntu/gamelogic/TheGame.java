package ir.ac.kntu.gamelogic;

import java.util.ArrayList;

import java.util.Scanner;


public class TheGame {
    int roundCount = 0;
    static ArrayList<Soldiers> redSoldiers = new ArrayList<>();
    static ArrayList<Soldiers> blueSoldiers = new ArrayList<>();



    public void fight(){
        int indexOfFightingRedSoldier = RandomHelper.nextInt(redSoldiers.size());
        int indexOfFightingBlueSoldier = RandomHelper.nextInt(blueSoldiers.size());
        redSoldiers.get(indexOfFightingRedSoldier).getGun().setCalibre7(RandomHelper.nextBoolean());
        blueSoldiers.get(indexOfFightingBlueSoldier).getGun().setCalibre7(RandomHelper.nextBoolean());
        if(redSoldiers.get(indexOfFightingRedSoldier).getGun().getClass().getSimpleName().equals("SniperRifle")){
             ((SniperRifle) redSoldiers.get(indexOfFightingRedSoldier).getGun()).setZoom(RandomHelper.nextBoolean());
        }
        if(blueSoldiers.get(indexOfFightingBlueSoldier).getGun().getClass().getSimpleName().equals("SniperRifle")){
            ((SniperRifle) blueSoldiers.get(indexOfFightingBlueSoldier).getGun()).setZoom(RandomHelper.nextBoolean());
        }
        boolean redOrBlue = RandomHelper.nextBoolean();
        System.out.println("------------------ The " + roundCount + " round begins------------------");
        for(int i=0 ; i<2 ; i++) {
            if (redOrBlue) {
                if (redSoldiers.get(indexOfFightingRedSoldier).getGun().isCalibre7()) {
                    if (RandomHelper.nextInt(100) < redSoldiers.get(indexOfFightingRedSoldier).getGun().getRange() - 10) {
                        blueSoldiers.get(indexOfFightingBlueSoldier).setLives
                                ((blueSoldiers.get(indexOfFightingBlueSoldier).getLives()) -
                                        (redSoldiers.get(indexOfFightingRedSoldier).getGun().getDamage() + 10));
                        System.out.println( redSoldiers.get(indexOfFightingRedSoldier).getId()+" hit the blue soldier " +
                                "with high calibre bullet\n");
                        if(blueSoldiers.get(indexOfFightingBlueSoldier).getLives()<=0){
                            i++;
                        }
                    } else {
                        System.out.println(redSoldiers.get(indexOfFightingRedSoldier).getId() +"from the red team missed !" +
                                " and "+blueSoldiers.get(indexOfFightingBlueSoldier).getId() +" got away\n");
                    }
                } else {
                    if (RandomHelper.nextInt(100) < redSoldiers.get(indexOfFightingRedSoldier).getGun().getRange() + 15) {
                        blueSoldiers.get(indexOfFightingBlueSoldier).setLives
                                ((blueSoldiers.get(indexOfFightingBlueSoldier).getLives()) -
                                        (redSoldiers.get(indexOfFightingRedSoldier).getGun().getDamage()));
                        System.out.println( redSoldiers.get(indexOfFightingRedSoldier).getId()+" hit the blue soldier " +
                                "with low calibre bullet\n");
                        if(blueSoldiers.get(indexOfFightingBlueSoldier).getLives()<=0){
                            i++;
                        }
                    } else {
                        System.out.println(redSoldiers.get(indexOfFightingRedSoldier).getId() +" from the red team missed !" +
                                " and "+blueSoldiers.get(indexOfFightingBlueSoldier).getId() +" got away\n");
                    }
                }
                redOrBlue = false;
            } else {
                if (blueSoldiers.get(indexOfFightingBlueSoldier).getGun().isCalibre7()) {
                    if (RandomHelper.nextInt(100) < blueSoldiers.get(indexOfFightingBlueSoldier).getGun().getRange() - 10) {
                        redSoldiers.get(indexOfFightingRedSoldier).setLives
                                ((redSoldiers.get(indexOfFightingRedSoldier).getLives()) -
                                        (blueSoldiers.get(indexOfFightingBlueSoldier).getGun().getDamage() + 10));
                        System.out.println( blueSoldiers.get(indexOfFightingBlueSoldier).getId()+" hit the red soldier " +
                                "with high calibre bullet\n");
                        if(redSoldiers.get(indexOfFightingRedSoldier).getLives()<=0){
                            i++;
                        }
                    } else {
                        System.out.println(blueSoldiers.get(indexOfFightingBlueSoldier).getId() +"from the blue team missed!" +
                                " and "+redSoldiers.get(indexOfFightingRedSoldier).getId() +" got away\n");
                    }
                } else {
                    if (RandomHelper.nextInt(100) < blueSoldiers.get(indexOfFightingBlueSoldier).getGun().getRange() + 15) {
                        redSoldiers.get(indexOfFightingRedSoldier).setLives
                                ((redSoldiers.get(indexOfFightingRedSoldier).getLives()) -
                                        (blueSoldiers.get(indexOfFightingBlueSoldier).getGun().getDamage()));
                        System.out.println( blueSoldiers.get(indexOfFightingBlueSoldier).getId()+" hit the red soldier " +
                                "with low calibre bullet\n");
                        if(redSoldiers.get(indexOfFightingRedSoldier).getLives()<=0){
                            i++;
                        }
                    } else {
                        System.out.println(blueSoldiers.get(indexOfFightingBlueSoldier).getId() +"from the blue team missed!" +
                                " and "+redSoldiers.get(indexOfFightingRedSoldier).getId() +" got away\n");
                    }
                }
                redOrBlue = true;
            }

        }
        if(redSoldiers.get(indexOfFightingRedSoldier).getLives()>0)
        System.out.println("remaining lives of the red soldier:" + redSoldiers.get(indexOfFightingRedSoldier).getLives());

        if(blueSoldiers.get(indexOfFightingBlueSoldier).getLives()>0)
            System.out.println("remaining lives of the blue soldier:" + blueSoldiers.get(indexOfFightingBlueSoldier).getLives());

        if(redSoldiers.get(indexOfFightingRedSoldier).getLives()<=0){
            System.out.println("the "+redSoldiers.get(indexOfFightingRedSoldier).getId() + " from the red team is dead!\n");
            redSoldiers.remove(indexOfFightingRedSoldier);
        }
        if(blueSoldiers.get(indexOfFightingBlueSoldier).getLives()<=0){
            System.out.println(("the "+blueSoldiers.get(indexOfFightingBlueSoldier).getId() + "from the blue team is dead!\n"));
            blueSoldiers.remove(indexOfFightingBlueSoldier);
        }
    }

    public void printStatus(){
        System.out.println("------------------end of Round " + roundCount + "------------------");
        System.out.println("number of surviving red soldiers: " + redSoldiers.size() + "\n number of surviving blue soldiers: " + blueSoldiers.size());
    }

    public void gameFlow(){
        Scanner in = new Scanner(System.in);
        boolean Flag = true;
        while (Flag) {
            System.out.println("enter how many soldier you want each side to have:");
            int numberOfSoldiers = in.nextInt();
            Soldiers.soldierSetting(numberOfSoldiers);
            while (redSoldiers.size()!=0 && blueSoldiers.size()!=0) {
                fight();
                roundCount++;
                printStatus();
            }
            if(redSoldiers.size() == 0){
                System.out.println("------------------The game is over------------------\n" +
                        "The blue team won the game ! congrats soldiers you made your country proud\n" +
                        " number of surviving soldiers : "+blueSoldiers.size() +
                        "\nnumber of rounds : " + roundCount);
            }else{
                System.out.println("------------------The game is over------------------\n" +
                        "The red team won the game ! congrats soldiers you made your country proud\n" +
                        " number of surviving soldiers : "+redSoldiers.size() +
                        "\nnumber of rounds" + roundCount);
            }
            redSoldiers.clear();
            blueSoldiers.clear();
            System.out.println("\ndo you want to play another round if your answer is yes enter true if not enter false");
            Flag = in.nextBoolean();
        }
    }




}
