package hearc.ch.starstrat.dataBase.Remplissage;


import hearc.ch.starstrat.dataBase.BDD.Race_entitiesBDD;
import hearc.ch.starstrat.dataBase.models.Race_entities;

/**
 * Created by Kevin on 24/12/2014.
 */
public class InsertRaceEntities
{

    public InsertRaceEntities(Race_entitiesBDD race)
    {
        unit(race);
        batiment(race);
        upgrade(race);

        //terran(race);
        //zerg(race);
        //protoss(race);
    }

    private void upgrade(Race_entitiesBDD race)
    {
        String path = "images/upgrade/";

        //////////////////////TERRAN ///////////////////////
        //Infantry Weapons Level 1
        Race_entities upInfantryLVL1 = new Race_entities();
        upInfantryLVL1.setId_races(3);
        upInfantryLVL1.setName("Infantry Weapons Level 1");
        upInfantryLVL1.setId_type(3);
        upInfantryLVL1.setTime_creation(160);
        upInfantryLVL1.setPathImage(path+"1.png");
        race.insertRaceEntities(upInfantryLVL1);

        //Infantry Weapons Level 2
        Race_entities upInfantryLVL2 = new Race_entities();
        upInfantryLVL2.setId_races(3);
        upInfantryLVL2.setName("Infantry Weapons Level 2");
        upInfantryLVL2.setId_type(3);
        upInfantryLVL2.setTime_creation(190);
        upInfantryLVL2.setPathImage(path+"2.png");
        race.insertRaceEntities(upInfantryLVL2);

        //Infantry Weapons Level 3
        Race_entities upInfantryLVL3 = new Race_entities();
        upInfantryLVL3.setId_races(3);
        upInfantryLVL3.setName("Infantry Weapons Level 3");
        upInfantryLVL3.setId_type(3);
        upInfantryLVL3.setTime_creation(220);
        upInfantryLVL3.setPathImage(path+"3.png");
        race.insertRaceEntities(upInfantryLVL3);

        //Vehicule Weapons Level 1
        Race_entities vehiculeWeaponsLVL1 = new Race_entities();
        vehiculeWeaponsLVL1.setId_races(3);
        vehiculeWeaponsLVL1.setName("Vehicule Weapons Level 1");
        vehiculeWeaponsLVL1.setId_type(3);
        vehiculeWeaponsLVL1.setTime_creation(160);
        vehiculeWeaponsLVL1.setPathImage(path+"4.png");
        race.insertRaceEntities(vehiculeWeaponsLVL1);

        //Vehicule Weapons Level 2
        Race_entities vehiculeWeaponsLVL2 = new Race_entities();
        vehiculeWeaponsLVL2.setId_races(3);
        vehiculeWeaponsLVL2.setName("Vehicule Weapons Level 2");
        vehiculeWeaponsLVL2.setId_type(3);
        vehiculeWeaponsLVL2.setTime_creation(190);
        vehiculeWeaponsLVL2.setPathImage(path+"5.png");
        race.insertRaceEntities(vehiculeWeaponsLVL2);

        //Vehicule Weapons Level 3
        Race_entities vehiculeWeaponsLVL3 = new Race_entities();
        vehiculeWeaponsLVL3.setId_races(3);
        vehiculeWeaponsLVL3.setName("Vehicule Weapons Level 3");
        vehiculeWeaponsLVL3.setId_type(3);
        vehiculeWeaponsLVL3.setTime_creation(220);
        vehiculeWeaponsLVL3.setPathImage(path+"6.png");
        race.insertRaceEntities(vehiculeWeaponsLVL3);

        //Ship Weapons Level 1
        Race_entities shipWeaponsLVL1 = new Race_entities();
        shipWeaponsLVL1.setId_races(3);
        shipWeaponsLVL1.setName("Ship Weapons Level 1");
        shipWeaponsLVL1.setId_type(3);
        shipWeaponsLVL1.setTime_creation(160);
        shipWeaponsLVL1.setPathImage(path+"7.png");
        race.insertRaceEntities(shipWeaponsLVL1);

        //Ship Weapons Level 2
        Race_entities shipWeaponsLVL2 = new Race_entities();
        shipWeaponsLVL2.setId_races(3);
        shipWeaponsLVL2.setName("Ship Weapons Level 2");
        shipWeaponsLVL2.setId_type(3);
        shipWeaponsLVL2.setTime_creation(190);
        shipWeaponsLVL2.setPathImage(path+"8.png");
        race.insertRaceEntities(shipWeaponsLVL2);

        //Ship Weapons Level 3
        Race_entities shipWeaponsLVL3 = new Race_entities();
        shipWeaponsLVL3.setId_races(3);
        shipWeaponsLVL3.setName("Ship Weapons Level 3");
        shipWeaponsLVL3.setId_type(3);
        shipWeaponsLVL3.setTime_creation(220);
        shipWeaponsLVL3.setPathImage(path+"9.png");
        race.insertRaceEntities(shipWeaponsLVL3);

        //Infantry Armor Level 1
        Race_entities upInfantryArmorLVL1 = new Race_entities();
        upInfantryArmorLVL1.setId_races(3);
        upInfantryArmorLVL1.setName("Infantry Armor Level 1");
        upInfantryArmorLVL1.setId_type(3);
        upInfantryArmorLVL1.setTime_creation(160);
        upInfantryArmorLVL1.setPathImage(path+"10.png");
        race.insertRaceEntities(upInfantryArmorLVL1);

        //Infantry Armor Level 2
        Race_entities upInfantryArmorLVL2 = new Race_entities();
        upInfantryArmorLVL2.setId_races(3);
        upInfantryArmorLVL2.setName("Infantry Armor Level 2");
        upInfantryArmorLVL2.setId_type(3);
        upInfantryArmorLVL2.setTime_creation(190);
        upInfantryArmorLVL2.setPathImage(path+"11.png");
        race.insertRaceEntities(upInfantryArmorLVL2);

        //Infantry Armor Level 3
        Race_entities upInfantryArmorLVL3 = new Race_entities();
        upInfantryArmorLVL3.setId_races(3);
        upInfantryArmorLVL3.setName("Infantry Armor Level 3");
        upInfantryArmorLVL3.setId_type(3);
        upInfantryArmorLVL3.setTime_creation(220);
        upInfantryArmorLVL3.setPathImage(path+"12.png");
        race.insertRaceEntities(upInfantryArmorLVL3);

        //Upgrade Vehicle and Ship Plating Level 1
        Race_entities upVehiculeShieldLVL1 = new Race_entities();
        upVehiculeShieldLVL1.setId_races(3);
        upVehiculeShieldLVL1.setName("Upgrade Vehicle and Ship Plating Level 1");
        upVehiculeShieldLVL1.setId_type(3);
        upVehiculeShieldLVL1.setTime_creation(160);
        upVehiculeShieldLVL1.setPathImage(path+"13.png");
        race.insertRaceEntities(upVehiculeShieldLVL1);

        //Upgrade Vehicle and Ship Plating Level 2
        Race_entities upVehiculeShieldLVL2 = new Race_entities();
        upVehiculeShieldLVL2.setId_races(3);
        upVehiculeShieldLVL2.setName("Upgrade Vehicle and Ship Plating Level 2");
        upVehiculeShieldLVL2.setId_type(3);
        upVehiculeShieldLVL2.setTime_creation(190);
        upVehiculeShieldLVL2.setPathImage(path+"14.png");
        race.insertRaceEntities(upVehiculeShieldLVL2);

        //Upgrade Vehicle and Ship Plating Level 3
        Race_entities upVehiculeShieldLVL3 = new Race_entities();
        upVehiculeShieldLVL3.setId_races(3);
        upVehiculeShieldLVL3.setName("Upgrade Vehicle and Ship Plating Level 3");
        upVehiculeShieldLVL3.setId_type(3);
        upVehiculeShieldLVL3.setTime_creation(220);
        upVehiculeShieldLVL3.setPathImage(path+"15.png");
        race.insertRaceEntities(upVehiculeShieldLVL3);

        //Hi-Sec Auto Tracking
        Race_entities autoTracking = new Race_entities();
        autoTracking.setId_races(3);
        autoTracking.setName("Hi-Sec Auto Tracking");
        autoTracking.setId_type(3);
        autoTracking.setTime_creation(80);
        autoTracking.setPathImage(path+"16.png");
        race.insertRaceEntities(autoTracking);

        //Cloaking Field
        Race_entities cloakingField = new Race_entities();
        cloakingField.setId_races(3);
        cloakingField.setName("Cloaking Field");
        cloakingField.setId_type(3);
        cloakingField.setTime_creation(110);
        cloakingField.setPathImage(path+"17.png");
        race.insertRaceEntities(cloakingField);

        //Concussive Shells
        Race_entities concusiveShells = new Race_entities();
        concusiveShells.setId_races(3);
        concusiveShells.setName("Concussive Shells");
        concusiveShells.setId_type(3);
        concusiveShells.setTime_creation(60);
        concusiveShells.setPathImage(path+"18.png");
        race.insertRaceEntities(concusiveShells);

        //Personal Cloaking
        Race_entities personalCloaking = new Race_entities();
        personalCloaking.setId_races(3);
        personalCloaking.setName("Personal Cloaking");
        personalCloaking.setId_type(3);
        personalCloaking.setTime_creation(120);
        personalCloaking.setPathImage(path+"19.png");
        race.insertRaceEntities(personalCloaking);

        //Stimpack
        Race_entities stim = new Race_entities();
        stim.setId_races(3);
        stim.setName("Stimpack");
        stim.setId_type(3);
        stim.setTime_creation(170);
        stim.setPathImage(path+"20.png");
        race.insertRaceEntities(stim);

        //Weapon Refit
        Race_entities weaponsRefit = new Race_entities();
        weaponsRefit.setId_races(3);
        weaponsRefit.setName("Weapon Refit");
        weaponsRefit.setId_type(3);
        weaponsRefit.setTime_creation(60);
        weaponsRefit.setPathImage(path+"21.png");
        race.insertRaceEntities(weaponsRefit);

        //Research Behermoth Reactor
        Race_entities researchBehermoth = new Race_entities();
        researchBehermoth.setId_races(3);
        researchBehermoth.setName("Research Behermoth Reactor");
        researchBehermoth.setId_type(3);
        researchBehermoth.setTime_creation(80);
        researchBehermoth.setPathImage(path+"22.png");
        race.insertRaceEntities(researchBehermoth);

        //Caduceus Reactor
        Race_entities caduceusReactor = new Race_entities();
        caduceusReactor.setId_races(3);
        caduceusReactor.setName("Caduceus Reactor");
        caduceusReactor.setId_type(3);
        caduceusReactor.setTime_creation(80);
        caduceusReactor.setPathImage(path+"23.png");
        race.insertRaceEntities(caduceusReactor);

        //Corvid Reactor
        Race_entities corvidReactor = new Race_entities();
        corvidReactor.setId_races(3);
        corvidReactor.setName("Corvid Reactor");
        corvidReactor.setId_type(3);
        corvidReactor.setTime_creation(110);
        corvidReactor.setPathImage(path+"24.png");
        race.insertRaceEntities(corvidReactor);

        //Moebius Reactor
        Race_entities moebiusReactor = new Race_entities();
        moebiusReactor.setId_races(3);
        moebiusReactor.setName("Moebius Reactor");
        moebiusReactor.setId_type(3);
        moebiusReactor.setTime_creation(80);
        moebiusReactor.setPathImage(path+"25.png");
        race.insertRaceEntities(moebiusReactor);

        //Drilling Claws
        Race_entities drillingCaws = new Race_entities();
        drillingCaws.setId_races(3);
        drillingCaws.setName("Drilling Claws");
        drillingCaws.setId_type(3);
        drillingCaws.setTime_creation(110);
        drillingCaws.setPathImage(path+"26.png");
        race.insertRaceEntities(drillingCaws);

        //Transformation Servos
        Race_entities transformationServos = new Race_entities();
        transformationServos.setId_races(3);
        transformationServos.setName("ransformation Servos");
        transformationServos.setId_type(3);
        transformationServos.setTime_creation(110);
        transformationServos.setPathImage(path+"27.png");
        race.insertRaceEntities(transformationServos);

        //Structure Armor
        Race_entities structureArmor = new Race_entities();
        structureArmor.setId_races(3);
        structureArmor.setName("Building Armor");
        structureArmor.setId_type(3);
        structureArmor.setTime_creation(140);
        structureArmor.setPathImage(path+"28.png");
        race.insertRaceEntities(structureArmor);

        //Combat Shield
        Race_entities combatShield = new Race_entities();
        combatShield.setId_races(3);
        combatShield.setName("Combat Shield");
        combatShield.setId_type(3);
        combatShield.setTime_creation(110);
        combatShield.setPathImage(path+"29.png");
        race.insertRaceEntities(combatShield);

        //Durable Materials
        Race_entities durableMaterials = new Race_entities();
        durableMaterials.setId_races(3);
        durableMaterials.setName("Durable Materials");
        durableMaterials.setId_type(3);
        durableMaterials.setTime_creation(110);
        durableMaterials.setPathImage(path+"30.png");
        race.insertRaceEntities(durableMaterials);

        //Infernal Pre-Igniter
        Race_entities infernalIgniter = new Race_entities();
        infernalIgniter.setId_races(3);
        infernalIgniter.setName("Infernal Pre-Igniter");
        infernalIgniter.setId_type(3);
        infernalIgniter.setTime_creation(110);
        infernalIgniter.setPathImage(path+"31.png");
        race.insertRaceEntities(infernalIgniter);

        //Neosteel Frame
        Race_entities neoSteel = new Race_entities();
        neoSteel.setId_races(3);
        neoSteel.setName("Neosteel Frame");
        neoSteel.setId_type(3);
        neoSteel.setTime_creation(110);
        neoSteel.setPathImage(path+"32.png");
        race.insertRaceEntities(neoSteel);


        //////////////////////ZERG ///////////////////////
        //Melee Attacks Level 1
        Race_entities meleAttacklvl1 = new Race_entities();
        meleAttacklvl1.setId_races(1);
        meleAttacklvl1.setName("Melee Attacks Level 1");
        meleAttacklvl1.setId_type(3);
        meleAttacklvl1.setTime_creation(160);
        meleAttacklvl1.setPathImage(path+"33.png");
        race.insertRaceEntities(meleAttacklvl1);

        //Melee Attacks Level 2
        Race_entities meleAttacklvl2 = new Race_entities();
        meleAttacklvl2.setId_races(1);
        meleAttacklvl2.setName("Melee Attacks Level 2");
        meleAttacklvl2.setId_type(3);
        meleAttacklvl2.setTime_creation(190);
        meleAttacklvl2.setPathImage(path+"34.png");
        race.insertRaceEntities(meleAttacklvl2);

        //Melee Attacks Level 3
        Race_entities meleAttacklvl3 = new Race_entities();
        meleAttacklvl3.setId_races(1);
        meleAttacklvl3.setName("Melee Attacks Level 3");
        meleAttacklvl3.setId_type(3);
        meleAttacklvl3.setTime_creation(220);
        meleAttacklvl3.setPathImage(path+"35.png");
        race.insertRaceEntities(meleAttacklvl3);

        //Missile Attacks Level 1
        Race_entities missileAttacklvl1 = new Race_entities();
        missileAttacklvl1.setId_races(1);
        missileAttacklvl1.setName("Missile Attacks Level 1");
        missileAttacklvl1.setId_type(3);
        missileAttacklvl1.setTime_creation(160);
        missileAttacklvl1.setPathImage(path+"36.png");
        race.insertRaceEntities(missileAttacklvl1);

        //Missile Attacks Level 2
        Race_entities missileAttacklvl2 = new Race_entities();
        missileAttacklvl2.setId_races(1);
        missileAttacklvl2.setName("Missile Attacks Level 2");
        missileAttacklvl2.setId_type(3);
        missileAttacklvl2.setTime_creation(190);
        missileAttacklvl2.setPathImage(path+"37.png");
        race.insertRaceEntities(missileAttacklvl2);

        //Missile Attacks Level 3
        Race_entities missileAttacklvl3 = new Race_entities();
        missileAttacklvl3.setId_races(1);
        missileAttacklvl3.setName("Missile Attacks Level 3");
        missileAttacklvl3.setId_type(3);
        missileAttacklvl3.setTime_creation(220);
        missileAttacklvl3.setPathImage(path+"38.png");
        race.insertRaceEntities(missileAttacklvl3);

        //Flyer  Attacks Level 1
        Race_entities flyerAttacklvl1 = new Race_entities();
        flyerAttacklvl1.setId_races(1);
        flyerAttacklvl1.setName("Flyer  Attacks Level 1");
        flyerAttacklvl1.setId_type(3);
        flyerAttacklvl1.setTime_creation(160);
        flyerAttacklvl1.setPathImage(path+"39.png");
        race.insertRaceEntities(flyerAttacklvl1);

        //Flyer  Attacks Level 2
        Race_entities flyerAttacklvl2 = new Race_entities();
        flyerAttacklvl2.setId_races(1);
        flyerAttacklvl2.setName("Flyer  Attacks Level 2");
        flyerAttacklvl2.setId_type(3);
        flyerAttacklvl2.setTime_creation(190);
        flyerAttacklvl2.setPathImage(path+"40.png");
        race.insertRaceEntities(flyerAttacklvl2);

        //Flyer  Attacks Level 3
        Race_entities flyerAttacklvl3 = new Race_entities();
        flyerAttacklvl3.setId_races(1);
        flyerAttacklvl3.setName("Flyer  Attacks Level 3");
        flyerAttacklvl3.setId_type(3);
        flyerAttacklvl3.setTime_creation(220);
        flyerAttacklvl3.setPathImage(path+"41.png");
        race.insertRaceEntities(flyerAttacklvl3);

        //Ground  Carapace  Level 1
        Race_entities groundCarapaceLvl1 = new Race_entities();
        groundCarapaceLvl1.setId_races(1);
        groundCarapaceLvl1.setName("Ground  Carapace  Level 1");
        groundCarapaceLvl1.setId_type(3);
        groundCarapaceLvl1.setTime_creation(160);
        groundCarapaceLvl1.setPathImage(path+"42.png");
        race.insertRaceEntities(groundCarapaceLvl1);

        //Ground  Carapace  Level 2
        Race_entities groundCarapaceLvl2 = new Race_entities();
        groundCarapaceLvl2.setId_races(1);
        groundCarapaceLvl2.setName("Ground  Carapace  Level 2");
        groundCarapaceLvl2.setId_type(3);
        groundCarapaceLvl2.setTime_creation(190);
        groundCarapaceLvl2.setPathImage(path+"43.png");
        race.insertRaceEntities(groundCarapaceLvl2);

        //Ground  Carapace  Level 3
        Race_entities groundCarapaceLvl3 = new Race_entities();
        groundCarapaceLvl3.setId_races(1);
        groundCarapaceLvl3.setName("Ground  Carapace  Level 3");
        groundCarapaceLvl3.setId_type(3);
        groundCarapaceLvl3.setTime_creation(220);
        groundCarapaceLvl3.setPathImage(path+"44.png");
        race.insertRaceEntities(groundCarapaceLvl3);

        //Flyer   Carapace  Level 1
        Race_entities flyerCarapaceLvl1 = new Race_entities();
        flyerCarapaceLvl1.setId_races(1);
        flyerCarapaceLvl1.setName("Flyer   Carapace  Level 1");
        flyerCarapaceLvl1.setId_type(3);
        flyerCarapaceLvl1.setTime_creation(160);
        flyerCarapaceLvl1.setPathImage(path+"45.png");
        race.insertRaceEntities(flyerCarapaceLvl1);

        //Flyer   Carapace  Level 2
        Race_entities flyerCarapaceLvl2 = new Race_entities();
        flyerCarapaceLvl2.setId_races(1);
        flyerCarapaceLvl2.setName("Flyer   Carapace  Level 2");
        flyerCarapaceLvl2.setId_type(3);
        flyerCarapaceLvl2.setTime_creation(190);
        flyerCarapaceLvl2.setPathImage(path+"46.png");
        race.insertRaceEntities(flyerCarapaceLvl2);

        //Flyer   Carapace  Level 3
        Race_entities flyerCarapaceLvl3 = new Race_entities();
        flyerCarapaceLvl3.setId_races(1);
        flyerCarapaceLvl3.setName("Flyer   Carapace  Level 3");
        flyerCarapaceLvl3.setId_type(3);
        flyerCarapaceLvl3.setTime_creation(220);
        flyerCarapaceLvl3.setPathImage(path+"47.png");
        race.insertRaceEntities(flyerCarapaceLvl3);

        //Chitinous Plating
        Race_entities chtinousPlating = new Race_entities();
        chtinousPlating.setId_races(1);
        chtinousPlating.setName("Chitinous Plating");
        chtinousPlating.setId_type(3);
        chtinousPlating.setTime_creation(110);
        chtinousPlating.setPathImage(path+"48.png");
        race.insertRaceEntities(chtinousPlating);

        //Centrifugal Hooks
        Race_entities centrifugalHooks = new Race_entities();
        centrifugalHooks.setId_races(1);
        centrifugalHooks.setName("Centrifugal Hooks");
        centrifugalHooks.setId_type(3);
        centrifugalHooks.setTime_creation(110);
        centrifugalHooks.setPathImage(path+"49.png");
        race.insertRaceEntities(centrifugalHooks);

        //Glial Reconstitution
        Race_entities glialReconstitution = new Race_entities();
        glialReconstitution.setId_races(1);
        glialReconstitution.setName("Glial Reconstitution");
        glialReconstitution.setId_type(3);
        glialReconstitution.setTime_creation(110);
        glialReconstitution.setPathImage(path+"50.png");
        race.insertRaceEntities(glialReconstitution);

        //Metabolic Boost
        Race_entities metabolicBoost = new Race_entities();
        metabolicBoost.setId_races(1);
        metabolicBoost.setName("Metabolic Boost");
        metabolicBoost.setId_type(3);
        metabolicBoost.setTime_creation(110);
        metabolicBoost.setPathImage(path+"51.png");
        race.insertRaceEntities(metabolicBoost);

        //Pneumatized Carapace
        Race_entities pneumaticCarapace = new Race_entities();
        pneumaticCarapace.setId_races(1);
        pneumaticCarapace.setName("Pneumatized Carapace");
        pneumaticCarapace.setId_type(3);
        pneumaticCarapace.setTime_creation(60);
        pneumaticCarapace.setPathImage(path+"52.png");
        race.insertRaceEntities(pneumaticCarapace);

        //Muscular Augments
        Race_entities muscularAugments = new Race_entities();
        muscularAugments.setId_races(1);
        muscularAugments.setName("Muscular Augments");
        muscularAugments.setId_type(3);
        muscularAugments.setTime_creation(100);
        muscularAugments.setPathImage(path+"53.png");
        race.insertRaceEntities(muscularAugments);

        //Grooved Spines
        Race_entities groovedSpines = new Race_entities();
        groovedSpines.setId_races(1);
        groovedSpines.setName("Grooved Spines");
        groovedSpines.setId_type(3);
        groovedSpines.setTime_creation(80);
        groovedSpines.setPathImage(path+"54.png");
        race.insertRaceEntities(groovedSpines);

        //Burrow
        Race_entities burrow = new Race_entities();
        burrow.setId_races(1);
        burrow.setName("Burrow");
        burrow.setId_type(3);
        burrow.setTime_creation(100);
        burrow.setPathImage(path+"55.png");
        race.insertRaceEntities(burrow);

        //Neural Parasite
        Race_entities neuralParasite = new Race_entities();
        neuralParasite.setId_races(1);
        neuralParasite.setName("Neural Parasite");
        neuralParasite.setId_type(3);
        neuralParasite.setTime_creation(110);
        neuralParasite.setPathImage(path+"56.png");
        race.insertRaceEntities(neuralParasite);

        //Ventral Sacs
        Race_entities ventralSacs = new Race_entities();
        ventralSacs.setId_races(1);
        ventralSacs.setName("Ventral Sacs");
        ventralSacs.setId_type(3);
        ventralSacs.setTime_creation(130);
        ventralSacs.setPathImage(path+"57.png");
        race.insertRaceEntities(ventralSacs);

        //Pathogen Glands
        Race_entities pathogenGlands = new Race_entities();
        pathogenGlands.setId_races(1);
        pathogenGlands.setName("Pathogen Glands");
        pathogenGlands.setId_type(3);
        pathogenGlands.setTime_creation(80);
        pathogenGlands.setPathImage(path+"58.png");
        race.insertRaceEntities(pathogenGlands);

        //Adrenal Glands
        Race_entities adrenalGlands = new Race_entities();
        adrenalGlands.setId_races(1);
        adrenalGlands.setName("Adrenal Glands");
        adrenalGlands.setId_type(3);
        adrenalGlands.setTime_creation(130);
        adrenalGlands.setPathImage(path+"59.png");
        race.insertRaceEntities(adrenalGlands);

        //Tunneling Claws
        Race_entities tunnelingClaws = new Race_entities();
        tunnelingClaws.setId_races(1);
        tunnelingClaws.setName("Tunneling Claws");
        tunnelingClaws.setId_type(3);
        tunnelingClaws.setTime_creation(110);
        tunnelingClaws.setPathImage(path+"60.png");
        race.insertRaceEntities(tunnelingClaws);

        //Enduring Locusts
        Race_entities enduringLocust = new Race_entities();
        enduringLocust.setId_races(1);
        enduringLocust.setName("Enduring Locusts");
        enduringLocust.setId_type(3);
        enduringLocust.setTime_creation(120);
        enduringLocust.setPathImage(path+"61.png");
        race.insertRaceEntities(enduringLocust);

        //////////////////////PROTOSS ///////////////////////
        //Ground Weapons Level 1
        Race_entities groundWeaponsLevel1 = new Race_entities();
        groundWeaponsLevel1.setId_races(2);
        groundWeaponsLevel1.setName("Ground Weapons Level 1");
        groundWeaponsLevel1.setId_type(3);
        groundWeaponsLevel1.setTime_creation(160);
        groundWeaponsLevel1.setPathImage(path+"62.png");
        race.insertRaceEntities(groundWeaponsLevel1);

        //Ground Weapons Level 2
        Race_entities groundWeaponsLevel2 = new Race_entities();
        groundWeaponsLevel2.setId_races(2);
        groundWeaponsLevel2.setName("Ground Weapons Level 2");
        groundWeaponsLevel2.setId_type(3);
        groundWeaponsLevel2.setTime_creation(190);
        groundWeaponsLevel2.setPathImage(path+"63.png");
        race.insertRaceEntities(groundWeaponsLevel2);

        //Ground Weapons Level 3
        Race_entities groundWeaponsLevel3 = new Race_entities();
        groundWeaponsLevel3.setId_races(2);
        groundWeaponsLevel3.setName("Ground Weapons Level 3");
        groundWeaponsLevel3.setId_type(3);
        groundWeaponsLevel3.setTime_creation(220);
        groundWeaponsLevel3.setPathImage(path+"64.png");
        race.insertRaceEntities(groundWeaponsLevel3);

        //Air Weapons Level 1
        Race_entities airWeaponsLevel1 = new Race_entities();
        airWeaponsLevel1.setId_races(2);
        airWeaponsLevel1.setName("Air Weapons Level 1");
        airWeaponsLevel1.setId_type(3);
        airWeaponsLevel1.setTime_creation(160);
        airWeaponsLevel1.setPathImage(path+"65.png");
        race.insertRaceEntities(airWeaponsLevel1);

        //Air Weapons Level 2
        Race_entities airWeaponsLevel2 = new Race_entities();
        airWeaponsLevel2.setId_races(2);
        airWeaponsLevel2.setName("Air Weapons Level 2");
        airWeaponsLevel2.setId_type(3);
        airWeaponsLevel2.setTime_creation(190);
        airWeaponsLevel2.setPathImage(path+"66.png");
        race.insertRaceEntities(airWeaponsLevel2);

        //Air Weapons Level 3
        Race_entities airWeaponsLevel3 = new Race_entities();
        airWeaponsLevel3.setId_races(2);
        airWeaponsLevel3.setName("Air Weapons Level 3");
        airWeaponsLevel3.setId_type(3);
        airWeaponsLevel3.setTime_creation(220);
        airWeaponsLevel3.setPathImage(path+"67.png");
        race.insertRaceEntities(airWeaponsLevel3);

        //Ground Armor Level 1
        Race_entities groundArmorLevel1 = new Race_entities();
        groundArmorLevel1.setId_races(2);
        groundArmorLevel1.setName("Ground Armor Level 1");
        groundArmorLevel1.setId_type(3);
        groundArmorLevel1.setTime_creation(160);
        groundArmorLevel1.setPathImage(path+"68.png");
        race.insertRaceEntities(groundArmorLevel1);

        //Ground Armor Level 2
        Race_entities groundArmorLevel2 = new Race_entities();
        groundArmorLevel2.setId_races(2);
        groundArmorLevel2.setName("Ground Armor Level 2");
        groundArmorLevel2.setId_type(3);
        groundArmorLevel2.setTime_creation(190);
        groundArmorLevel2.setPathImage(path+"69.png");
        race.insertRaceEntities(groundArmorLevel2);

        //Ground Armor Level 3
        Race_entities groundArmorLevel3 = new Race_entities();
        groundArmorLevel3.setId_races(2);
        groundArmorLevel3.setName("Ground Armor Level 3");
        groundArmorLevel3.setId_type(3);
        groundArmorLevel3.setTime_creation(220);
        groundArmorLevel3.setPathImage(path+"70.png");
        race.insertRaceEntities(groundArmorLevel3);

        //Air Armor Level 1
        Race_entities airArmorLevel1 = new Race_entities();
        airArmorLevel1.setId_races(2);
        airArmorLevel1.setName("Air Armor Level 1");
        airArmorLevel1.setId_type(3);
        airArmorLevel1.setTime_creation(160);
        airArmorLevel1.setPathImage(path+"71.png");
        race.insertRaceEntities(airArmorLevel1);

        //Air Armor Level 2
        Race_entities airArmorLevel2 = new Race_entities();
        airArmorLevel2.setId_races(2);
        airArmorLevel2.setName("Air Armor Level 2");
        airArmorLevel2.setId_type(3);
        airArmorLevel2.setTime_creation(190);
        airArmorLevel2.setPathImage(path+"72.png");
        race.insertRaceEntities(airArmorLevel2);

        //Air Armor Level 3
        Race_entities airArmorLevel3 = new Race_entities();
        airArmorLevel3.setId_races(2);
        airArmorLevel3.setName("Air Armor Level 3");
        airArmorLevel3.setId_type(3);
        airArmorLevel3.setTime_creation(220);
        airArmorLevel3.setPathImage(path+"73.png");
        race.insertRaceEntities(airArmorLevel3);

        //Shields Level 1
        Race_entities shieldLevel1 = new Race_entities();
        shieldLevel1.setId_races(2);
        shieldLevel1.setName("Shields Level 1");
        shieldLevel1.setId_type(3);
        shieldLevel1.setTime_creation(160);
        shieldLevel1.setPathImage(path+"74.png");
        race.insertRaceEntities(shieldLevel1);

        //Shields Level 2
        Race_entities shieldLevel2 = new Race_entities();
        shieldLevel2.setId_races(2);
        shieldLevel2.setName("Shields Level 2");
        shieldLevel2.setId_type(3);
        shieldLevel2.setTime_creation(190);
        shieldLevel2.setPathImage(path+"75.png");
        race.insertRaceEntities(shieldLevel2);

        //Shields Level 3
        Race_entities shieldLevel3 = new Race_entities();
        shieldLevel3.setId_races(2);
        shieldLevel3.setName("Shields Level 3");
        shieldLevel3.setId_type(3);
        shieldLevel3.setTime_creation(220);
        shieldLevel3.setPathImage(path+"76.png");
        race.insertRaceEntities(shieldLevel3);

        //Charge
        Race_entities charge = new Race_entities();
        charge.setId_races(2);
        charge.setName("Charge");
        charge.setId_type(3);
        charge.setTime_creation(140);
        charge.setPathImage(path+"77.png");
        race.insertRaceEntities(charge);

        //Gravitic Boosters
        Race_entities graviticBoosters = new Race_entities();
        graviticBoosters.setId_races(2);
        graviticBoosters.setName("Gravitic Boosters");
        graviticBoosters.setId_type(3);
        graviticBoosters.setTime_creation(80);
        graviticBoosters.setPathImage(path+"78.png");
        race.insertRaceEntities(graviticBoosters);

        //Gravitic Drive
        Race_entities graviticDrive = new Race_entities();
        graviticDrive.setId_races(2);
        graviticDrive.setName("Gravitic Drive");
        graviticDrive.setId_type(3);
        graviticDrive.setTime_creation(80);
        graviticDrive.setPathImage(path+"79.png");
        race.insertRaceEntities(graviticDrive);

        //Anion Pulse-Crystals
        Race_entities anionPulseCrystal = new Race_entities();
        anionPulseCrystal.setId_races(2);
        anionPulseCrystal.setName("Anion Pulse-Crystals");
        anionPulseCrystal.setId_type(3);
        anionPulseCrystal.setTime_creation(90);
        anionPulseCrystal.setPathImage(path+"80.png");
        race.insertRaceEntities(anionPulseCrystal);

        //Extended Thermal Lance
        Race_entities extendedThermalLance = new Race_entities();
        extendedThermalLance.setId_races(2);
        extendedThermalLance.setName("Extended Thermal Lance");
        extendedThermalLance.setId_type(3);
        extendedThermalLance.setTime_creation(140);
        extendedThermalLance.setPathImage(path+"81.png");
        race.insertRaceEntities(extendedThermalLance);

        //Psionic Storm
        Race_entities psionicStorm = new Race_entities();
        psionicStorm.setId_races(2);
        psionicStorm.setName("Psionic Storm");
        psionicStorm.setId_type(3);
        psionicStorm.setTime_creation(110);
        psionicStorm.setPathImage(path+"82.png");
        race.insertRaceEntities(psionicStorm);

        //Blink
        Race_entities blink = new Race_entities();
        blink.setId_races(2);
        blink.setName("Blink");
        blink.setId_type(3);
        blink.setTime_creation(170);
        blink.setPathImage(path+"83.png");
        race.insertRaceEntities(blink);

        //Hallucination
        Race_entities hallucination = new Race_entities();
        hallucination.setId_races(2);
        hallucination.setName("Hallucination");
        hallucination.setId_type(3);
        hallucination.setTime_creation(80);
        hallucination.setPathImage(path+"84.png");
        race.insertRaceEntities(hallucination);

        //Graviton Catapult
        Race_entities gravitonCatapult = new Race_entities();
        gravitonCatapult.setId_races(2);
        gravitonCatapult.setName("Graviton Catapult");
        gravitonCatapult.setId_type(3);
        gravitonCatapult.setTime_creation(80);
        gravitonCatapult.setPathImage(path+"85.png");
        race.insertRaceEntities(gravitonCatapult);

    }

    private void batiment(Race_entitiesBDD race)
    {
        String path = "images/build/";

        //////////////////////TERRAN ///////////////////////
        //Command Center
        Race_entities cc = new Race_entities();
        cc.setId_races(3);
        cc.setName("Command Center");
        cc.setId_type(1);
        cc.setTime_creation(40);
        cc.setPathImage(path+"1.jpg");
        race.insertRaceEntities(cc);

        //Refinery
        Race_entities refinery = new Race_entities();
        refinery.setId_races(3);
        refinery.setName("Refinery");
        refinery.setId_type(1);
        refinery.setTime_creation(30);
        refinery.setPathImage(path+"2.jpg");
        race.insertRaceEntities(refinery);

        //Supply Depot
        Race_entities depot = new Race_entities();
        depot.setId_races(3);
        depot.setName("Supply Depot");
        depot.setId_type(1);
        depot.setTime_creation(30);
        depot.setPathImage(path+"3.jpg");
        race.insertRaceEntities(depot);

        //Barracks
        Race_entities barracks = new Race_entities();
        barracks.setId_races(3);
        barracks.setName("Barracks");
        barracks.setId_type(1);
        barracks.setTime_creation(65);
        barracks.setPathImage(path+"4.jpg");
        race.insertRaceEntities(barracks);

        //Engineering Bay
        Race_entities eb = new Race_entities();
        eb.setId_races(3);
        eb.setName("Engineering Bay");
        eb.setId_type(1);
        eb.setTime_creation(35);
        eb.setPathImage(path+"5.jpg");
        race.insertRaceEntities(eb);

        //Bunker
        Race_entities bunker = new Race_entities();
        bunker.setId_races(3);
        bunker.setName("Bunker");
        bunker.setId_type(1);
        bunker.setTime_creation(40);
        bunker.setPathImage(path+"6.jpg");
        race.insertRaceEntities(bunker);

        //Missile Turret
        Race_entities turret = new Race_entities();
        turret.setId_races(3);
        turret.setName("Missile Turret");
        turret.setId_type(1);
        turret.setTime_creation(25);
        turret.setPathImage(path+"7.jpg");
        race.insertRaceEntities(turret);

        //Sensor Tower
        Race_entities tower = new Race_entities();
        tower.setId_races(3);
        tower.setName("Sensor Tower");
        tower.setId_type(1);
        tower.setTime_creation(25);
        tower.setPathImage(path+"8.jpg");
        race.insertRaceEntities(tower);

        //Ghost Academy
        Race_entities ghostAcademy = new Race_entities();
        ghostAcademy.setId_races(3);
        ghostAcademy.setName("Ghost Academy");
        ghostAcademy.setId_type(1);
        ghostAcademy.setTime_creation(40);
        ghostAcademy.setPathImage(path+"9.jpg");
        race.insertRaceEntities(ghostAcademy);

        //Factory
        Race_entities factory = new Race_entities();
        factory.setId_races(3);
        factory.setName("Factory");
        factory.setId_type(1);
        factory.setTime_creation(60);
        factory.setPathImage(path+"10.jpg");
        race.insertRaceEntities(factory);

        //Armory
        Race_entities armory = new Race_entities();
        armory.setId_races(3);
        armory.setName("Armory");
        armory.setId_type(1);
        armory.setTime_creation(65);
        armory.setPathImage(path+"11.jpg");
        race.insertRaceEntities(armory);

        //Starport
        Race_entities starport = new Race_entities();
        starport.setId_races(3);
        starport.setName("Starport");
        starport.setId_type(1);
        starport.setTime_creation(50);
        starport.setPathImage(path+"12.jpg");
        race.insertRaceEntities(starport);

        //Fusion Core
        Race_entities fusionCore = new Race_entities();
        fusionCore.setId_races(3);
        fusionCore.setName("Fusion Core");
        fusionCore.setId_type(1);
        fusionCore.setTime_creation(65);
        fusionCore.setPathImage(path+"13.jpg");
        race.insertRaceEntities(fusionCore);


        //////////////////////ZERG ///////////////////////
        //Hatchery
        Race_entities hatch = new Race_entities();
        hatch.setId_races(1);
        hatch.setName("Hatchery");
        hatch.setId_type(1);
        hatch.setTime_creation(100);
        hatch.setPathImage(path+"14.jpg");
        race.insertRaceEntities(hatch);

        //Extractor
        Race_entities extractor = new Race_entities();
        extractor.setId_races(1);
        extractor.setName("Extractor");
        extractor.setId_type(1);
        extractor.setTime_creation(30);
        extractor.setPathImage(path+"15.jpg");
        race.insertRaceEntities(extractor);

        //Spawning Pool
        Race_entities pool = new Race_entities();
        pool.setId_races(1);
        pool.setName("Spawning Pool");
        pool.setId_type(1);
        pool.setTime_creation(65);
        pool.setPathImage(path+"16.jpg");
        race.insertRaceEntities(pool);

        //Evolution Chamber
        Race_entities evolveChamber = new Race_entities();
        evolveChamber.setId_races(1);
        evolveChamber.setName("Evolution Chamber");
        evolveChamber.setId_type(1);
        evolveChamber.setTime_creation(35);
        evolveChamber.setPathImage(path+"17.jpg");
        race.insertRaceEntities(evolveChamber);

        //Spine Crawler
        Race_entities spineCrawler = new Race_entities();
        spineCrawler.setId_races(1);
        spineCrawler.setName("Spine Crawler");
        spineCrawler.setId_type(1);
        spineCrawler.setTime_creation(50);
        spineCrawler.setPathImage(path+"18.jpg");
        race.insertRaceEntities(spineCrawler);

        //Spore Crawler
        Race_entities sporeCrawler = new Race_entities();
        sporeCrawler.setId_races(1);
        sporeCrawler.setName("Spore Crawler");
        sporeCrawler.setId_type(1);
        sporeCrawler.setTime_creation(30);
        sporeCrawler.setPathImage(path+"19.jpg");
        race.insertRaceEntities(sporeCrawler);

        //Roach Warren
        Race_entities roachWarren = new Race_entities();
        roachWarren.setId_races(1);
        roachWarren.setName("Roach Warren");
        roachWarren.setId_type(1);
        roachWarren.setTime_creation(55);
        roachWarren.setPathImage(path+"20.jpg");
        race.insertRaceEntities(roachWarren);

        //Banneling Nest
        Race_entities bannelingNest = new Race_entities();
        bannelingNest.setId_races(1);
        bannelingNest.setName("Banneling Nest");
        bannelingNest.setId_type(1);
        bannelingNest.setTime_creation(60);
        bannelingNest.setPathImage(path+"21.jpg");
        race.insertRaceEntities(bannelingNest);

        //Lair
        Race_entities lair = new Race_entities();
        lair.setId_races(1);
        lair.setName("Lair");
        lair.setId_type(1);
        lair.setTime_creation(80);
        lair.setPathImage(path+"22.jpg");
        race.insertRaceEntities(lair);

        //Hydralisk Den
        Race_entities hydraDen = new Race_entities();
        hydraDen.setId_races(1);
        hydraDen.setName("Hydralisk Den");
        hydraDen.setId_type(1);
        hydraDen.setTime_creation(40);
        hydraDen.setPathImage(path+"23.jpg");
        race.insertRaceEntities(hydraDen);

        //Infestation Pit
        Race_entities infestPit = new Race_entities();
        infestPit.setId_races(1);
        infestPit.setName("Infestation Pit");
        infestPit.setId_type(1);
        infestPit.setTime_creation(50);
        infestPit.setPathImage(path+"24.jpg");
        race.insertRaceEntities(infestPit);

        //Hive
        Race_entities hive = new Race_entities();
        hive.setId_races(1);
        hive.setName("Hive");
        hive.setId_type(1);
        hive.setTime_creation(100);
        hive.setPathImage(path+"25.jpg");
        race.insertRaceEntities(hive);

        //Spire
        Race_entities spire = new Race_entities();
        spire.setId_races(1);
        spire.setName("Spire");
        spire.setId_type(1);
        spire.setTime_creation(100);
        spire.setPathImage(path+"26.jpg");
        race.insertRaceEntities(spire);

        //Greater Spire
        Race_entities greaterSpire = new Race_entities();
        greaterSpire.setId_races(1);
        greaterSpire.setName("Greater Spire");
        greaterSpire.setId_type(1);
        greaterSpire.setTime_creation(100);
        greaterSpire.setPathImage(path+"27.jpg");
        race.insertRaceEntities(greaterSpire);

        //Nydus Network
        Race_entities nydusNetwork = new Race_entities();
        nydusNetwork.setId_races(1);
        nydusNetwork.setName("Nydus Network");
        nydusNetwork.setId_type(1);
        nydusNetwork.setTime_creation(20);
        nydusNetwork.setPathImage(path+"28.jpg");
        race.insertRaceEntities(nydusNetwork);

        //Nydus Worm
        Race_entities nydusWorm = new Race_entities();
        nydusWorm.setId_races(1);
        nydusWorm.setName("Nydus Worm");
        nydusWorm.setId_type(1);
        nydusWorm.setTime_creation(20);
        nydusWorm.setPathImage(path+"29.jpg");
        race.insertRaceEntities(nydusWorm);

        //////////////////////PROTOSS ///////////////////////
        //Pylon
        Race_entities pylon = new Race_entities();
        pylon.setId_races(2);
        pylon.setName("Pylon");
        pylon.setId_type(1);
        pylon.setTime_creation(25);
        pylon.setPathImage(path+"30.jpg");
        race.insertRaceEntities(pylon);

        //Assimilator
        Race_entities assimilator = new Race_entities();
        assimilator.setId_races(2);
        assimilator.setName("Assimilator");
        assimilator.setId_type(1);
        assimilator.setTime_creation(30);
        assimilator.setPathImage(path+"31.jpg");
        race.insertRaceEntities(assimilator);

        //Nexus
        Race_entities nexus = new Race_entities();
        nexus.setId_races(2);
        nexus.setName("Nexus");
        nexus.setId_type(1);
        nexus.setTime_creation(100);
        nexus.setPathImage(path+"32.jpg");
        race.insertRaceEntities(nexus);

        //Gateway
        Race_entities gateway = new Race_entities();
        gateway.setId_races(2);
        gateway.setName("Gateway");
        gateway.setId_type(1);
        gateway.setTime_creation(65);
        gateway.setPathImage(path+"33.jpg");
        race.insertRaceEntities(gateway);

        //Warpgate
        Race_entities warpgate = new Race_entities();
        warpgate.setId_races(2);
        warpgate.setName("Warpgate");
        warpgate.setId_type(1);
        warpgate.setTime_creation(10);
        warpgate.setPathImage(path+"34.jpg");
        race.insertRaceEntities(warpgate);

        //Forge
        Race_entities forge = new Race_entities();
        forge.setId_races(2);
        forge.setName("Forge");
        forge.setId_type(1);
        forge.setTime_creation(35);
        forge.setPathImage(path+"35.jpg");
        race.insertRaceEntities(forge);

        //Photon Cannon
        Race_entities photonCanon = new Race_entities();
        photonCanon.setId_races(2);
        photonCanon.setName("Photon Cannon");
        photonCanon.setId_type(1);
        photonCanon.setTime_creation(40);
        photonCanon.setPathImage(path+"36.jpg");
        race.insertRaceEntities(photonCanon);

        //Cybernetics Core
        Race_entities cyberneticsCore = new Race_entities();
        cyberneticsCore.setId_races(2);
        cyberneticsCore.setName("Cybernetics Core");
        cyberneticsCore.setId_type(1);
        cyberneticsCore.setTime_creation(50);
        cyberneticsCore.setPathImage(path+"37.jpg");
        race.insertRaceEntities(cyberneticsCore);

        //Twilight Council
        Race_entities twilight = new Race_entities();
        twilight.setId_races(2);
        twilight.setName("Twilight Council");
        twilight.setId_type(1);
        twilight.setTime_creation(50);
        twilight.setPathImage(path+"38.jpg");
        race.insertRaceEntities(twilight);

        //Stargate
        Race_entities stargate = new Race_entities();
        stargate.setId_races(2);
        stargate.setName("Stargate");
        stargate.setId_type(1);
        stargate.setTime_creation(60);
        stargate.setPathImage(path+"39.jpg");
        race.insertRaceEntities(stargate);

        //Robotics Facility
        Race_entities robot = new Race_entities();
        robot.setId_races(2);
        robot.setName("Robotics Facility");
        robot.setId_type(1);
        robot.setTime_creation(65);
        robot.setPathImage(path+"40.jpg");
        race.insertRaceEntities(robot);

        //Templar Archives
        Race_entities archive = new Race_entities();
        archive.setId_races(2);
        archive.setName("Templar Archives");
        archive.setId_type(1);
        archive.setTime_creation(50);
        archive.setPathImage(path+"41.jpg");
        race.insertRaceEntities(archive);

        //Fleet Beacon
        Race_entities baliseFlotte = new Race_entities();
        baliseFlotte.setId_races(2);
        baliseFlotte.setName("Fleet Beacon");
        baliseFlotte.setId_type(1);
        baliseFlotte.setTime_creation(60);
        baliseFlotte.setPathImage(path+"42.jpg");
        race.insertRaceEntities(baliseFlotte);

        //Robotics Bay
        Race_entities roboticBay = new Race_entities();
        roboticBay.setId_races(2);
        roboticBay.setName("Robotics Bay");
        roboticBay.setId_type(1);
        roboticBay.setTime_creation(65);
        roboticBay.setPathImage(path+"43.jpg");
        race.insertRaceEntities(roboticBay);

        //Dark Shrine
        Race_entities darkShrine = new Race_entities();
        darkShrine.setId_races(2);
        darkShrine.setName("Dark Shrine");
        darkShrine.setId_type(1);
        darkShrine.setTime_creation(100);
        darkShrine.setPathImage(path+"44.jpg");
        race.insertRaceEntities(darkShrine);

    }

    private void unit(Race_entitiesBDD race)
    {

        String path = "images/unit/";
        //////////////////////TERRAN //////////////////////
        //SCV
        Race_entities scv = new Race_entities();
        scv.setId_races(3);
        scv.setName("SCV");
        scv.setId_type(2);
        scv.setTime_creation(17);
        scv.setPathImage(path+"1.jpg");
        race.insertRaceEntities(scv);

        //MARINE
        Race_entities marine = new Race_entities();
        marine.setId_races(3);
        marine.setName("Marine");
        marine.setId_type(2);
        marine.setTime_creation(25);
        marine.setPathImage(path+"2.jpg");
        race.insertRaceEntities(marine);

        //Marauder
        Race_entities marauder = new Race_entities();
        marauder.setId_races(3);
        marauder.setName("Marauder");
        marauder.setId_type(2);
        marauder.setTime_creation(30);
        marauder.setPathImage(path+"3.jpg");
        race.insertRaceEntities(marauder);

        //Reaper
        Race_entities reaper = new Race_entities();
        reaper.setId_races(3);
        reaper.setName("Reaper");
        reaper.setId_type(2);
        reaper.setTime_creation(45);
        reaper.setPathImage(path+"4.jpg");
        race.insertRaceEntities(reaper);

        //Ghost
        Race_entities ghost = new Race_entities();
        ghost.setId_races(3);
        ghost.setName("Ghost");
        ghost.setId_type(2);
        ghost.setTime_creation(40);
        ghost.setPathImage(path+"5.jpg");
        race.insertRaceEntities(ghost);

        //Hellion
        Race_entities hellion = new Race_entities();
        hellion.setId_races(3);
        hellion.setName("Hellion");
        hellion.setId_type(2);
        hellion.setTime_creation(30);
        hellion.setPathImage(path+"6.jpg");
        race.insertRaceEntities(hellion);

        //Tank
        Race_entities tank = new Race_entities();
        tank.setId_races(3);
        tank.setName("Tank");
        tank.setId_type(2);
        tank.setTime_creation(45);
        tank.setPathImage(path+"7.jpg");
        race.insertRaceEntities(tank);

        //Thor
        Race_entities thor = new Race_entities();
        thor.setId_races(3);
        thor.setName("Thor");
        thor.setId_type(2);
        thor.setTime_creation(60);
        thor.setPathImage(path+"8.jpg");
        race.insertRaceEntities(thor);

        //Viking
        Race_entities viking = new Race_entities();
        viking.setId_races(3);
        viking.setName("Viking");
        viking.setId_type(2);
        viking.setTime_creation(42);
        viking.setPathImage(path+"9.jpg");
        race.insertRaceEntities(viking);

        //Medivac
        Race_entities medivac = new Race_entities();
        medivac.setId_races(3);
        medivac.setName("Medivac");
        medivac.setId_type(2);
        medivac.setTime_creation(42);
        medivac.setPathImage(path+"10.jpg");
        race.insertRaceEntities(medivac);

        //Raven
        Race_entities raven = new Race_entities();
        raven.setId_races(3);
        raven.setName("Raven");
        raven.setId_type(2);
        raven.setTime_creation(60);
        raven.setPathImage(path+"11.jpg");
        race.insertRaceEntities(raven);

        //Banshee
        Race_entities banshee = new Race_entities();
        banshee.setId_races(3);
        banshee.setName("Banshee");
        banshee.setId_type(2);
        banshee.setTime_creation(60);
        banshee.setPathImage(path+"12.jpg");
        race.insertRaceEntities(banshee);

        //Battlecruiser
        Race_entities bc = new Race_entities();
        bc.setId_races(3);
        bc.setName("Battlecruiser");
        bc.setId_type(2);
        bc.setTime_creation(90);
        bc.setPathImage(path+"13.jpg");
        race.insertRaceEntities(bc);

        //Hellbat
        Race_entities hellbat = new Race_entities();
        hellbat.setId_races(3);
        hellbat.setName("Hellbat");
        hellbat.setId_type(2);
        hellbat.setTime_creation(30);
        hellbat.setPathImage(path+"14.jpg");
        race.insertRaceEntities(hellbat);

        //Widow Mine
        Race_entities mine = new Race_entities();
        mine.setId_races(3);
        mine.setName("Widow Mine");
        mine.setId_type(2);
        mine.setTime_creation(40);
        mine.setPathImage(path+"15.jpg");
        race.insertRaceEntities(mine);

        //////////////////////ZERG //////////////////////
        //Drone
        Race_entities drone = new Race_entities();
        drone.setId_races(1);
        drone.setName("Drone");
        drone.setId_type(2);
        drone.setTime_creation(17);
        drone.setPathImage(path+"16.jpg");
        race.insertRaceEntities(drone);

        //Overlord
        Race_entities overlord = new Race_entities();
        overlord.setId_races(1);
        overlord.setName("Overlord");
        overlord.setId_type(2);
        overlord.setTime_creation(25);
        overlord.setPathImage(path+"17.jpg");
        race.insertRaceEntities(overlord);

        //Zergling
        Race_entities zergling = new Race_entities();
        zergling.setId_races(1);
        zergling.setName("Zergling");
        zergling.setId_type(2);
        zergling.setTime_creation(24);
        zergling.setPathImage(path+"18.jpg");
        race.insertRaceEntities(zergling);

        //Queen
        Race_entities queen = new Race_entities();
        queen.setId_races(1);
        queen.setName("Queen");
        queen.setId_type(2);
        queen.setTime_creation(50);
        queen.setPathImage(path+"19.jpg");
        race.insertRaceEntities(queen);

        //Hydralisk
        Race_entities hydra = new Race_entities();
        hydra.setId_races(1);
        hydra.setName("Hydralisk");
        hydra.setId_type(2);
        hydra.setTime_creation(33);
        hydra.setPathImage(path+"20.jpg");
        race.insertRaceEntities(hydra);

        //Baneling
        Race_entities baneling = new Race_entities();
        baneling.setId_races(1);
        baneling.setName("Baneling");
        baneling.setId_type(2);
        baneling.setTime_creation(20);
        baneling.setPathImage(path+"21.jpg");
        race.insertRaceEntities(baneling);

        //Overseer
        Race_entities overseer = new Race_entities();
        overseer.setId_races(1);
        overseer.setName("Overseer");
        overseer.setId_type(2);
        overseer.setTime_creation(17);
        overseer.setPathImage(path+"22.jpg");
        race.insertRaceEntities(overseer);

        //Roach
        Race_entities roach = new Race_entities();
        roach.setId_races(1);
        roach.setName("Roach");
        roach.setId_type(2);
        roach.setTime_creation(27);
        roach.setPathImage(path+"23.jpg");
        race.insertRaceEntities(roach);

        //Infestor
        Race_entities infest = new Race_entities();
        infest.setId_races(1);
        infest.setName("Infestor");
        infest.setId_type(2);
        infest.setTime_creation(50);
        infest.setPathImage(path+"24.jpg");
        race.insertRaceEntities(infest);

        //Mutalisk
        Race_entities muta = new Race_entities();
        muta.setId_races(1);
        muta.setName("Mutalisk");
        muta.setId_type(2);
        muta.setTime_creation(33);
        muta.setPathImage(path+"25.jpg");
        race.insertRaceEntities(muta);

        //Corruptor
        Race_entities corruptor = new Race_entities();
        corruptor.setId_races(1);
        corruptor.setName("Corruptor");
        corruptor.setId_type(2);
        corruptor.setTime_creation(40);
        corruptor.setPathImage(path+"26.jpg");
        race.insertRaceEntities(corruptor);

        //Ultralisk
        Race_entities ultra = new Race_entities();
        ultra.setId_races(1);
        ultra.setName("Ultralisk");
        ultra.setId_type(2);
        ultra.setTime_creation(55);
        ultra.setPathImage(path+"27.jpg");
        race.insertRaceEntities(ultra);

        //Brood Lord
        Race_entities broodLord = new Race_entities();
        broodLord.setId_races(1);
        broodLord.setName("Brood Lord");
        broodLord.setId_type(2);
        broodLord.setTime_creation(34);
        broodLord.setPathImage(path+"28.jpg");
        race.insertRaceEntities(broodLord);

        //Swarm Host
        Race_entities sh = new Race_entities();
        sh.setId_races(1);
        sh.setName("Swarm Host");
        sh.setId_type(2);
        sh.setTime_creation(40);
        sh.setPathImage(path+"29.jpg");
        race.insertRaceEntities(sh);

        //Viper
        Race_entities viper = new Race_entities();
        viper.setId_races(1);
        viper.setName("Viper");
        viper.setId_type(2);
        viper.setTime_creation(40);
        viper.setPathImage(path+"30.jpg");
        race.insertRaceEntities(viper);

        //////////////////////PROTOSS //////////////////////
        //Probe
        Race_entities probe = new Race_entities();
        probe.setId_races(2);
        probe.setName("Probe");
        probe.setId_type(2);
        probe.setTime_creation(17);
        probe.setPathImage(path+"31.jpg");
        race.insertRaceEntities(probe);

        //Zealot
        Race_entities zealot = new Race_entities();
        zealot.setId_races(2);
        zealot.setName("Zealot");
        zealot.setId_type(2);
        zealot.setTime_creation(38);
        zealot.setPathImage(path+"32.jpg");
        race.insertRaceEntities(zealot);

        //Stalker
        Race_entities stalker = new Race_entities();
        stalker.setId_races(2);
        stalker.setName("Stalker");
        stalker.setId_type(2);
        stalker.setTime_creation(42);
        stalker.setPathImage(path+"33.jpg");
        race.insertRaceEntities(stalker);

        //Sentry
        Race_entities sentry = new Race_entities();
        sentry.setId_races(2);
        sentry.setName("Sentry");
        sentry.setId_type(2);
        sentry.setTime_creation(37);
        sentry.setPathImage(path+"34.jpg");
        race.insertRaceEntities(sentry);

        //Observer
        Race_entities observer = new Race_entities();
        observer.setId_races(2);
        observer.setName("Observer");
        observer.setId_type(2);
        observer.setTime_creation(30);
        observer.setPathImage(path+"35.jpg");
        race.insertRaceEntities(observer);

        //Immortal
        Race_entities immo = new Race_entities();
        immo.setId_races(2);
        immo.setName("Immortal");
        immo.setId_type(2);
        immo.setTime_creation(55);
        immo.setPathImage(path+"36.jpg");
        race.insertRaceEntities(immo);

        //Warp Prism
        Race_entities warpPrism = new Race_entities();
        warpPrism.setId_races(2);
        warpPrism.setName("Warp Prism");
        warpPrism.setId_type(2);
        warpPrism.setTime_creation(50);
        warpPrism.setPathImage(path+"37.jpg");
        race.insertRaceEntities(warpPrism);

        //Colossus
        Race_entities coloss = new Race_entities();
        coloss.setId_races(2);
        coloss.setName("Colossus");
        coloss.setId_type(2);
        coloss.setTime_creation(75);
        coloss.setPathImage(path+"38.jpg");
        race.insertRaceEntities(coloss);

        //Phoenix
        Race_entities phoenix = new Race_entities();
        phoenix.setId_races(2);
        phoenix.setName("Phoenix");
        phoenix.setId_type(2);
        phoenix.setTime_creation(35);
        phoenix.setPathImage(path+"39.jpg");
        race.insertRaceEntities(phoenix);

        //Void Ray
        Race_entities violRay = new Race_entities();
        violRay.setId_races(2);
        violRay.setName("Void Ray");
        violRay.setId_type(2);
        violRay.setTime_creation(60);
        violRay.setPathImage(path+"40.jpg");
        race.insertRaceEntities(violRay);

        //High Templar
        Race_entities ht = new Race_entities();
        ht.setId_races(2);
        ht.setName("High Templar");
        ht.setId_type(2);
        ht.setTime_creation(55);
        ht.setPathImage(path+"41.jpg");
        race.insertRaceEntities(ht);

        //Dark Templar
        Race_entities dt = new Race_entities();
        dt.setId_races(2);
        dt.setName("Dark Templar");
        dt.setId_type(2);
        dt.setTime_creation(55);
        dt.setPathImage(path+"42.jpg");
        race.insertRaceEntities(dt);

        //Archon
        Race_entities archon = new Race_entities();
        archon.setId_races(2);
        archon.setName("Archon");
        archon.setId_type(2);
        archon.setTime_creation(12);
        archon.setPathImage(path+"43.jpg");
        race.insertRaceEntities(archon);

        //Carrier
        Race_entities carrier = new Race_entities();
        carrier.setId_races(2);
        carrier.setName("Carrier");
        carrier.setId_type(2);
        carrier.setTime_creation(120);
        carrier.setPathImage(path+"44.jpg");
        race.insertRaceEntities(carrier);

        //Mothership
        Race_entities mothership = new Race_entities();
        mothership.setId_races(2);
        mothership.setName("Mothership");
        mothership.setId_type(2);
        mothership.setTime_creation(100);
        mothership.setPathImage(path+"45.jpg");
        race.insertRaceEntities(mothership);

        //Mothership Core
        Race_entities mothershipCorps = new Race_entities();
        mothershipCorps.setId_races(2);
        mothershipCorps.setName("Mothership Core");
        mothershipCorps.setId_type(2);
        mothershipCorps.setTime_creation(30);
        mothershipCorps.setPathImage(path+"46.jpg");
        race.insertRaceEntities(mothershipCorps);

        //Oracle
        Race_entities oracle = new Race_entities();
        oracle.setId_races(2);
        oracle.setName("Oracle");
        oracle.setId_type(2);
        oracle.setTime_creation(50);
        oracle.setPathImage(path+"47.jpg");
        race.insertRaceEntities(oracle);

        //Tempest
        Race_entities tempest = new Race_entities();
        tempest.setId_races(2);
        tempest.setName("Tempest");
        tempest.setId_type(2);
        tempest.setTime_creation(60);
        tempest.setPathImage(path+"48.jpg");
        race.insertRaceEntities(tempest);
    }

    private void protoss(Race_entitiesBDD race)
    {
        //////////////////////UNITS ///////////////////////


        //////////////////////Batiments ///////////////////////
        //Pylon
        Race_entities pylon = new Race_entities();
        pylon.setId_races(2);
        pylon.setName("Pylon");
        pylon.setId_type(1);
        pylon.setTime_creation(25);
        race.insertRaceEntities(pylon);

        //Assimilator
        Race_entities assimilator = new Race_entities();
        assimilator.setId_races(2);
        assimilator.setName("Assimilator");
        assimilator.setId_type(1);
        assimilator.setTime_creation(30);
        race.insertRaceEntities(assimilator);

        //Nexus
        Race_entities nexus = new Race_entities();
        nexus.setId_races(2);
        nexus.setName("Nexus");
        nexus.setId_type(1);
        nexus.setTime_creation(100);
        race.insertRaceEntities(nexus);

        //Gateway
        Race_entities gateway = new Race_entities();
        gateway.setId_races(2);
        gateway.setName("Gateway");
        gateway.setId_type(1);
        gateway.setTime_creation(65);
        race.insertRaceEntities(gateway);

        //Warpgate
        Race_entities warpgate = new Race_entities();
        warpgate.setId_races(2);
        warpgate.setName("Warpgate");
        warpgate.setId_type(1);
        warpgate.setTime_creation(10);
        race.insertRaceEntities(warpgate);

        //Forge
        Race_entities forge = new Race_entities();
        forge.setId_races(2);
        forge.setName("Forge");
        forge.setId_type(1);
        forge.setTime_creation(35);
        race.insertRaceEntities(forge);

        //Photon Cannon
        Race_entities photonCanon = new Race_entities();
        photonCanon.setId_races(2);
        photonCanon.setName("Photon Cannon");
        photonCanon.setId_type(1);
        photonCanon.setTime_creation(40);
        race.insertRaceEntities(photonCanon);

        //Cybernetics Core
        Race_entities cyberneticsCore = new Race_entities();
        cyberneticsCore.setId_races(2);
        cyberneticsCore.setName("Cybernetics Core");
        cyberneticsCore.setId_type(1);
        cyberneticsCore.setTime_creation(50);
        race.insertRaceEntities(cyberneticsCore);

        //Twilight Council
        Race_entities twilight = new Race_entities();
        twilight.setId_races(2);
        twilight.setName("Twilight Council");
        twilight.setId_type(1);
        twilight.setTime_creation(50);
        race.insertRaceEntities(twilight);

        //Stargate
        Race_entities stargate = new Race_entities();
        stargate.setId_races(2);
        stargate.setName("Stargate");
        stargate.setId_type(1);
        stargate.setTime_creation(60);
        race.insertRaceEntities(stargate);

        //Robotics Facility
        Race_entities robot = new Race_entities();
        robot.setId_races(2);
        robot.setName("Robotics Facility");
        robot.setId_type(1);
        robot.setTime_creation(65);
        race.insertRaceEntities(robot);

        //Templar Archives
        Race_entities archive = new Race_entities();
        archive.setId_races(2);
        archive.setName("Templar Archives");
        archive.setId_type(1);
        archive.setTime_creation(50);
        race.insertRaceEntities(archive);

        //Fleet Beacon
        Race_entities baliseFlotte = new Race_entities();
        baliseFlotte.setId_races(2);
        baliseFlotte.setName("Fleet Beacon");
        baliseFlotte.setId_type(1);
        baliseFlotte.setTime_creation(60);
        race.insertRaceEntities(baliseFlotte);

        //Robotics Bay
        Race_entities roboticBay = new Race_entities();
        roboticBay.setId_races(2);
        roboticBay.setName("Robotics Bay");
        roboticBay.setId_type(1);
        roboticBay.setTime_creation(65);
        race.insertRaceEntities(roboticBay);

        //Dark Shrine
        Race_entities darkShrine = new Race_entities();
        darkShrine.setId_races(2);
        darkShrine.setName("Dark Shrine");
        darkShrine.setId_type(1);
        darkShrine.setTime_creation(100);
        race.insertRaceEntities(darkShrine);

    }

    private void zerg(Race_entitiesBDD race)
    {
        //////////////////////UNITS ///////////////////////


        //////////////////////Batiments ///////////////////////
        //Hatchery
        Race_entities hatch = new Race_entities();
        hatch.setId_races(1);
        hatch.setName("Hatchery");
        hatch.setId_type(1);
        hatch.setTime_creation(100);
        race.insertRaceEntities(hatch);

        //Extractor
        Race_entities extractor = new Race_entities();
        extractor.setId_races(1);
        extractor.setName("Extractor");
        extractor.setId_type(1);
        extractor.setTime_creation(30);
        race.insertRaceEntities(extractor);

        //Spawning Pool
        Race_entities pool = new Race_entities();
        pool.setId_races(1);
        pool.setName("Spawning Pool");
        pool.setId_type(1);
        pool.setTime_creation(65);
        race.insertRaceEntities(pool);

        //Evolution Chamber
        Race_entities evolveChamber = new Race_entities();
        evolveChamber.setId_races(1);
        evolveChamber.setName("Evolution Chamber");
        evolveChamber.setId_type(1);
        evolveChamber.setTime_creation(35);
        race.insertRaceEntities(evolveChamber);

        //Spine Crawler
        Race_entities spineCrawler = new Race_entities();
        spineCrawler.setId_races(1);
        spineCrawler.setName("Spine Crawler");
        spineCrawler.setId_type(1);
        spineCrawler.setTime_creation(50);
        race.insertRaceEntities(spineCrawler);

        //Spore Crawler
        Race_entities sporeCrawler = new Race_entities();
        sporeCrawler.setId_races(1);
        sporeCrawler.setName("Spore Crawler");
        sporeCrawler.setId_type(1);
        sporeCrawler.setTime_creation(30);
        race.insertRaceEntities(sporeCrawler);

        //Roach Warren
        Race_entities roachWarren = new Race_entities();
        roachWarren.setId_races(1);
        roachWarren.setName("Roach Warren");
        roachWarren.setId_type(1);
        roachWarren.setTime_creation(55);
        race.insertRaceEntities(roachWarren);

        //Banneling Nest
        Race_entities bannelingNest = new Race_entities();
        bannelingNest.setId_races(1);
        bannelingNest.setName("Banneling Nest");
        bannelingNest.setId_type(1);
        bannelingNest.setTime_creation(60);
        race.insertRaceEntities(bannelingNest);

        //Lair
        Race_entities lair = new Race_entities();
        lair.setId_races(1);
        lair.setName("Lair");
        lair.setId_type(1);
        lair.setTime_creation(80);
        race.insertRaceEntities(lair);

        //Hydralisk Den
        Race_entities hydraDen = new Race_entities();
        hydraDen.setId_races(1);
        hydraDen.setName("Hydralisk Den");
        hydraDen.setId_type(1);
        hydraDen.setTime_creation(40);
        race.insertRaceEntities(hydraDen);

        //Infestation Pit
        Race_entities infestPit = new Race_entities();
        infestPit.setId_races(1);
        infestPit.setName("Infestation Pit");
        infestPit.setId_type(1);
        infestPit.setTime_creation(50);
        race.insertRaceEntities(infestPit);

        //Hive
        Race_entities hive = new Race_entities();
        hive.setId_races(1);
        hive.setName("Hive");
        hive.setId_type(1);
        hive.setTime_creation(100);
        race.insertRaceEntities(hive);

        //Spire
        Race_entities spire = new Race_entities();
        spire.setId_races(1);
        spire.setName("Spire");
        spire.setId_type(1);
        spire.setTime_creation(100);
        race.insertRaceEntities(spire);

        //Greater Spire
        Race_entities greaterSpire = new Race_entities();
        greaterSpire.setId_races(1);
        greaterSpire.setName("Greater Spire");
        greaterSpire.setId_type(1);
        greaterSpire.setTime_creation(100);
        race.insertRaceEntities(greaterSpire);

        //Nydus Network
        Race_entities nydusNetwork = new Race_entities();
        nydusNetwork.setId_races(1);
        nydusNetwork.setName("Nydus Network");
        nydusNetwork.setId_type(1);
        nydusNetwork.setTime_creation(20);
        race.insertRaceEntities(nydusNetwork);

        //Nydus Worm
        Race_entities nydusWorm = new Race_entities();
        nydusWorm.setId_races(1);
        nydusWorm.setName("Nydus Worm");
        nydusWorm.setId_type(1);
        nydusWorm.setTime_creation(20);
        race.insertRaceEntities(nydusWorm);


    }

    private void terran(Race_entitiesBDD race)
    {
        //////////////////////UNITS ///////////////////////


        //////////////////////Batiments ///////////////////////
        //Command Center
        Race_entities cc = new Race_entities();
        cc.setId_races(3);
        cc.setName("Command Center");
        cc.setId_type(1);
        cc.setTime_creation(40);
        race.insertRaceEntities(cc);

        //Refinery
        Race_entities refinery = new Race_entities();
        refinery.setId_races(3);
        refinery.setName("Refinery");
        refinery.setId_type(1);
        refinery.setTime_creation(30);
        race.insertRaceEntities(refinery);

        //Supply Depot
        Race_entities depot = new Race_entities();
        depot.setId_races(3);
        depot.setName("Supply Depot");
        depot.setId_type(1);
        depot.setTime_creation(30);
        race.insertRaceEntities(depot);

        //Barracks
        Race_entities barracks = new Race_entities();
        barracks.setId_races(3);
        barracks.setName("Barracks");
        barracks.setId_type(1);
        barracks.setTime_creation(65);
        race.insertRaceEntities(barracks);

        //Engineering Bay
        Race_entities eb = new Race_entities();
        eb.setId_races(3);
        eb.setName("Engineering Bay");
        eb.setId_type(1);
        eb.setTime_creation(35);
        race.insertRaceEntities(eb);

        //Bunker
        Race_entities bunker = new Race_entities();
        bunker.setId_races(3);
        bunker.setName("Bunker");
        bunker.setId_type(1);
        bunker.setTime_creation(40);
        race.insertRaceEntities(bunker);

        //Missile Turret
        Race_entities turret = new Race_entities();
        turret.setId_races(3);
        turret.setName("Missile Turret");
        turret.setId_type(1);
        turret.setTime_creation(25);
        race.insertRaceEntities(turret);

        //Sensor Tower
        Race_entities tower = new Race_entities();
        tower.setId_races(3);
        tower.setName("Sensor Tower");
        tower.setId_type(1);
        tower.setTime_creation(25);
        race.insertRaceEntities(tower);

        //Ghost Academy
        Race_entities ghostAcademy = new Race_entities();
        ghostAcademy.setId_races(3);
        ghostAcademy.setName("Ghost Academy");
        ghostAcademy.setId_type(1);
        ghostAcademy.setTime_creation(40);
        race.insertRaceEntities(ghostAcademy);

        //Factory
        Race_entities factory = new Race_entities();
        factory.setId_races(3);
        factory.setName("Factory");
        factory.setId_type(1);
        factory.setTime_creation(60);
        race.insertRaceEntities(factory);

        //Armory
        Race_entities armory = new Race_entities();
        armory.setId_races(3);
        armory.setName("Armory");
        armory.setId_type(1);
        armory.setTime_creation(65);
        race.insertRaceEntities(armory);

        //Starport
        Race_entities starport = new Race_entities();
        starport.setId_races(3);
        starport.setName("Starport");
        starport.setId_type(1);
        starport.setTime_creation(50);
        race.insertRaceEntities(starport);

        //Fusion Core
        Race_entities fusionCore = new Race_entities();
        fusionCore.setId_races(3);
        fusionCore.setName("Fusion Core");
        fusionCore.setId_type(1);
        fusionCore.setTime_creation(65);
        race.insertRaceEntities(fusionCore);

        //////////////////////Recherche ///////////////////////
        /*
        //Orbital Command
        Race_entities orbitalCommand = new Race_entities();
        orbitalCommand.setId_races(3);
        orbitalCommand.setName("Orbital Command");
        orbitalCommand.setId_type(3);
        orbitalCommand.setTime_creation(35);
        race.insertRaceEntities(orbitalCommand);

        //Planetary Fortress
        Race_entities planetaryFortress = new Race_entities();
        planetaryFortress.setId_races(3);
        planetaryFortress.setName("Planetary Fortress");
        planetaryFortress.setId_type(3);
        planetaryFortress.setTime_creation(50);
        race.insertRaceEntities(planetaryFortress);

        //Combat Shield
        Race_entities combatShield = new Race_entities();
        combatShield.setId_races(3);
        combatShield.setName("Combat Shield");
        combatShield.setId_type(3);
        combatShield.setTime_creation(110);
        race.insertRaceEntities(combatShield);

        //Stimpack
        Race_entities stim = new Race_entities();
        stim.setId_races(3);
        stim.setName("Stimpack");
        stim.setId_type(3);
        stim.setTime_creation(170);
        race.insertRaceEntities(stim);

        //Concussive Shells
        Race_entities concusiveShells = new Race_entities();
        concusiveShells.setId_races(3);
        concusiveShells.setName("Concussive Shells");
        concusiveShells.setId_type(3);
        concusiveShells.setTime_creation(60);
        race.insertRaceEntities(concusiveShells);

        //Infantry Weapons Level 1
        Race_entities upInfantryLVL1 = new Race_entities();
        upInfantryLVL1.setId_races(3);
        upInfantryLVL1.setName("Infantry Weapons Level 1");
        upInfantryLVL1.setId_type(3);
        upInfantryLVL1.setTime_creation(160);
        race.insertRaceEntities(upInfantryLVL1);

        //Infantry Weapons Level 2
        Race_entities upInfantryLVL2 = new Race_entities();
        upInfantryLVL2.setId_races(3);
        upInfantryLVL2.setName("Infantry Weapons Level 2");
        upInfantryLVL2.setId_type(3);
        upInfantryLVL2.setTime_creation(190);
        race.insertRaceEntities(upInfantryLVL2);

        //Infantry Weapons Level 3
        Race_entities upInfantryLVL3 = new Race_entities();
        upInfantryLVL3.setId_races(3);
        upInfantryLVL3.setName("Infantry Weapons Level 3");
        upInfantryLVL3.setId_type(3);
        upInfantryLVL3.setTime_creation(220);
        race.insertRaceEntities(upInfantryLVL3);

        //Infantry Armor Level 1
        Race_entities upInfantryArmorLVL1 = new Race_entities();
        upInfantryArmorLVL1.setId_races(3);
        upInfantryArmorLVL1.setName("Infantry Armor Level 1");
        upInfantryArmorLVL1.setId_type(3);
        upInfantryArmorLVL1.setTime_creation(160);
        race.insertRaceEntities(upInfantryArmorLVL1);

        //Infantry Armor Level 2
        Race_entities upInfantryArmorLVL2 = new Race_entities();
        upInfantryArmorLVL2.setId_races(3);
        upInfantryArmorLVL2.setName("Infantry Armor Level 2");
        upInfantryArmorLVL2.setId_type(3);
        upInfantryArmorLVL2.setTime_creation(190);
        race.insertRaceEntities(upInfantryArmorLVL2);

        //Infantry Armor Level 3
        Race_entities upInfantryArmorLVL3 = new Race_entities();
        upInfantryArmorLVL3.setId_races(3);
        upInfantryArmorLVL3.setName("Infantry Armor Level 3");
        upInfantryArmorLVL3.setId_type(3);
        upInfantryArmorLVL3.setTime_creation(220);
        race.insertRaceEntities(upInfantryArmorLVL3);

        //Upgrade Vehicle and Ship Weapons Level 1
        Race_entities upVehiculeWeaponsLVL1 = new Race_entities();
        upVehiculeWeaponsLVL1.setId_races(3);
        upVehiculeWeaponsLVL1.setName("Upgrade Vehicle and Ship Weapons Level 1");
        upVehiculeWeaponsLVL1.setId_type(3);
        upVehiculeWeaponsLVL1.setTime_creation(160);
        race.insertRaceEntities(upVehiculeWeaponsLVL1);

        //Upgrade Vehicle and Ship Weapons Level 2
        Race_entities upVehiculeWeaponsLVL2 = new Race_entities();
        upVehiculeWeaponsLVL2.setId_races(3);
        upVehiculeWeaponsLVL2.setName("Upgrade Vehicle and Ship Weapons Level 2");
        upVehiculeWeaponsLVL2.setId_type(3);
        upVehiculeWeaponsLVL2.setTime_creation(190);
        race.insertRaceEntities(upVehiculeWeaponsLVL2);

        //Upgrade Vehicle and Ship Weapons Level 3
        Race_entities upVehiculeWeaponsLVL3 = new Race_entities();
        upVehiculeWeaponsLVL3.setId_races(3);
        upVehiculeWeaponsLVL3.setName("Upgrade Vehicle and Ship Weapons Level 3");
        upVehiculeWeaponsLVL3.setId_type(3);
        upVehiculeWeaponsLVL3.setTime_creation(220);
        race.insertRaceEntities(upVehiculeWeaponsLVL3);

        //Upgrade Vehicle and Ship Plating Level 1
        Race_entities upVehiculeShieldLVL1 = new Race_entities();
        upVehiculeShieldLVL1.setId_races(3);
        upVehiculeShieldLVL1.setName("Upgrade Vehicle and Ship Plating Level 1");
        upVehiculeShieldLVL1.setId_type(3);
        upVehiculeShieldLVL1.setTime_creation(160);
        race.insertRaceEntities(upVehiculeShieldLVL1);

        //Upgrade Vehicle and Ship Plating Level 2
        Race_entities upVehiculeShieldLVL2 = new Race_entities();
        upVehiculeShieldLVL2.setId_races(3);
        upVehiculeShieldLVL2.setName("Upgrade Vehicle and Ship Plating Level 2");
        upVehiculeShieldLVL2.setId_type(3);
        upVehiculeShieldLVL2.setTime_creation(190);
        race.insertRaceEntities(upVehiculeShieldLVL2);

        //Upgrade Vehicle and Ship Plating Level 3
        Race_entities upVehiculeShieldLVL3 = new Race_entities();
        upVehiculeShieldLVL3.setId_races(3);
        upVehiculeShieldLVL3.setName("Upgrade Vehicle and Ship Plating Level 3");
        upVehiculeShieldLVL3.setId_type(3);
        upVehiculeShieldLVL3.setTime_creation(220);
        race.insertRaceEntities(upVehiculeShieldLVL3);

        //Personal Cloaking
        Race_entities personalCloaking = new Race_entities();
        personalCloaking.setId_races(3);
        personalCloaking.setName("Personal Cloaking");
        personalCloaking.setId_type(3);
        personalCloaking.setTime_creation(120);
        race.insertRaceEntities(personalCloaking);

        //Silo with Nuke
        Race_entities nuke = new Race_entities();
        nuke.setId_races(3);
        nuke.setName("Silo with Nuke");
        nuke.setId_type(3);
        nuke.setTime_creation(60);
        race.insertRaceEntities(nuke);

        //Infernal Pre-Igniter
        Race_entities infernalIgniter = new Race_entities();
        infernalIgniter.setId_races(3);
        infernalIgniter.setName("Infernal Pre-Igniter");
        infernalIgniter.setId_type(3);
        infernalIgniter.setTime_creation(110);
        race.insertRaceEntities(infernalIgniter);

        //Drilling Claws
        Race_entities drillingCaws = new Race_entities();
        drillingCaws.setId_races(3);
        drillingCaws.setName("Drilling Claws");
        drillingCaws.setId_type(3);
        drillingCaws.setTime_creation(110);
        race.insertRaceEntities(drillingCaws);

        //Hi-Sec Auto Tracking
        Race_entities autoTracking = new Race_entities();
        autoTracking.setId_races(3);
        autoTracking.setName("Hi-Sec Auto Tracking");
        autoTracking.setId_type(3);
        autoTracking.setTime_creation(80);
        race.insertRaceEntities(autoTracking);

        //Neosteel Frame
        Race_entities neoSteel = new Race_entities();
        neoSteel.setId_races(3);
        neoSteel.setName("Neosteel Frame");
        neoSteel.setId_type(3);
        neoSteel.setTime_creation(110);
        race.insertRaceEntities(neoSteel);

        //Structure Armor
        Race_entities structureArmor = new Race_entities();
        structureArmor.setId_races(3);
        structureArmor.setName("Structure Armor");
        structureArmor.setId_type(3);
        structureArmor.setTime_creation(140);
        race.insertRaceEntities(structureArmor);

        //Caduceus Reactor
        Race_entities caduceusReactor = new Race_entities();
        caduceusReactor.setId_races(3);
        caduceusReactor.setName("Caduceus Reactor");
        caduceusReactor.setId_type(3);
        caduceusReactor.setTime_creation(80);
        race.insertRaceEntities(caduceusReactor);

        //Durable Materials
        Race_entities durableMaterials = new Race_entities();
        durableMaterials.setId_races(3);
        durableMaterials.setName("Durable Materials");
        durableMaterials.setId_type(3);
        durableMaterials.setTime_creation(110);
        race.insertRaceEntities(durableMaterials);

        //Corvid Reactor
        Race_entities corvidReactor = new Race_entities();
        corvidReactor.setId_races(3);
        corvidReactor.setName("Corvid Reactor");
        corvidReactor.setId_type(3);
        corvidReactor.setTime_creation(110);
        race.insertRaceEntities(corvidReactor);

        //Cloaking Field
        Race_entities cloakingField = new Race_entities();
        cloakingField.setId_races(3);
        cloakingField.setName("Cloaking Field");
        cloakingField.setId_type(3);
        cloakingField.setTime_creation(110);
        race.insertRaceEntities(cloakingField);

        //Weapon Refit
        Race_entities weaponsRefit = new Race_entities();
        weaponsRefit.setId_races(3);
        weaponsRefit.setName("Weapon Refit");
        weaponsRefit.setId_type(3);
        weaponsRefit.setTime_creation(60);
        race.insertRaceEntities(weaponsRefit);

        //Research Behermoth Reactor
        Race_entities researchBehermoth = new Race_entities();
        researchBehermoth.setId_races(3);
        researchBehermoth.setName("Research Behermoth Reactor");
        researchBehermoth.setId_type(3);
        researchBehermoth.setTime_creation(80);
        race.insertRaceEntities(researchBehermoth);

        //Scanner Sweep
        Race_entities scannerSweep = new Race_entities();
        scannerSweep.setId_races(3);
        scannerSweep.setName("Scanner Sweep");
        scannerSweep.setId_type(3);
        scannerSweep.setTime_creation(170);
        race.insertRaceEntities(scannerSweep);

        //Mule
        Race_entities mule = new Race_entities();
        mule.setId_races(3);
        mule.setName("Mule");
        mule.setId_type(3);
        mule.setTime_creation(0);
        race.insertRaceEntities(mule);

        //Extra Supplies
        Race_entities extraSupplies = new Race_entities();
        extraSupplies.setId_races(3);
        extraSupplies.setName("Extra Supplies");
        extraSupplies.setId_type(3);
        extraSupplies.setTime_creation(0);
        race.insertRaceEntities(extraSupplies);
        */
    }

}
