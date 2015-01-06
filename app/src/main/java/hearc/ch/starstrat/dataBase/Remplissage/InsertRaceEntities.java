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
        // batiment(race);
        //upgrade(race);

        //terran(race);
        //zerg(race);
        //protoss(race);
    }

    private void unit(Race_entitiesBDD race)
    {
        //////////////////////TERRAN //////////////////////
        //SCV
        Race_entities scv = new Race_entities();
        scv.setId_races(3);
        scv.setName("SCV");
        scv.setId_type(2);
        scv.setTime_creation(17);
        race.insertRaceEntities(scv);

        //MARINE
        Race_entities marine = new Race_entities();
        marine.setId_races(3);
        marine.setName("Marine");
        marine.setId_type(2);
        marine.setTime_creation(25);
        race.insertRaceEntities(marine);

        //Marauder
        Race_entities marauder = new Race_entities();
        marauder.setId_races(3);
        marauder.setName("Marauder");
        marauder.setId_type(2);
        marauder.setTime_creation(30);
        race.insertRaceEntities(marauder);

        //Reaper
        Race_entities reaper = new Race_entities();
        reaper.setId_races(3);
        reaper.setName("Reaper");
        reaper.setId_type(2);
        reaper.setTime_creation(45);
        race.insertRaceEntities(reaper);

        //Ghost
        Race_entities ghost = new Race_entities();
        ghost.setId_races(3);
        ghost.setName("Ghost");
        ghost.setId_type(2);
        ghost.setTime_creation(40);
        race.insertRaceEntities(ghost);

        //Hellion
        Race_entities hellion = new Race_entities();
        hellion.setId_races(3);
        hellion.setName("Hellion");
        hellion.setId_type(2);
        hellion.setTime_creation(30);
        race.insertRaceEntities(hellion);

        //Tank
        Race_entities tank = new Race_entities();
        tank.setId_races(3);
        tank.setName("Tank");
        tank.setId_type(2);
        tank.setTime_creation(45);
        race.insertRaceEntities(tank);

        //Thor
        Race_entities thor = new Race_entities();
        thor.setId_races(3);
        thor.setName("Thor");
        thor.setId_type(2);
        thor.setTime_creation(60);
        race.insertRaceEntities(thor);

        //Viking
        Race_entities viking = new Race_entities();
        viking.setId_races(3);
        viking.setName("Viking");
        viking.setId_type(2);
        viking.setTime_creation(42);
        race.insertRaceEntities(viking);

        //Medivac
        Race_entities medivac = new Race_entities();
        medivac.setId_races(3);
        medivac.setName("Medivac");
        medivac.setId_type(2);
        medivac.setTime_creation(42);
        race.insertRaceEntities(medivac);

        //Raven
        Race_entities raven = new Race_entities();
        raven.setId_races(3);
        raven.setName("Raven");
        raven.setId_type(2);
        raven.setTime_creation(60);
        race.insertRaceEntities(raven);

        //Banshee
        Race_entities banshee = new Race_entities();
        banshee.setId_races(3);
        banshee.setName("Banshee");
        banshee.setId_type(2);
        banshee.setTime_creation(60);
        race.insertRaceEntities(banshee);

        //Battlecruiser
        Race_entities bc = new Race_entities();
        bc.setId_races(3);
        bc.setName("Battlecruiser");
        bc.setId_type(2);
        bc.setTime_creation(90);
        race.insertRaceEntities(bc);

        //Hellbat
        Race_entities hellbat = new Race_entities();
        hellbat.setId_races(3);
        hellbat.setName("Hellbat");
        hellbat.setId_type(2);
        hellbat.setTime_creation(30);
        race.insertRaceEntities(hellbat);

        //Widow Mine
        Race_entities mine = new Race_entities();
        mine.setId_races(3);
        mine.setName("Widow Mine");
        mine.setId_type(2);
        mine.setTime_creation(40);
        race.insertRaceEntities(mine);

        //////////////////////ZERG //////////////////////
        //Drone
        Race_entities drone = new Race_entities();
        drone.setId_races(1);
        drone.setName("Drone");
        drone.setId_type(2);
        drone.setTime_creation(17);
        race.insertRaceEntities(drone);

        //Overlord
        Race_entities overlord = new Race_entities();
        overlord.setId_races(1);
        overlord.setName("Overlord");
        overlord.setId_type(2);
        overlord.setTime_creation(25);
        race.insertRaceEntities(overlord);

        //Zergling
        Race_entities zergling = new Race_entities();
        zergling.setId_races(1);
        zergling.setName("Zergling");
        zergling.setId_type(2);
        zergling.setTime_creation(24);
        race.insertRaceEntities(zergling);

        //Queen
        Race_entities queen = new Race_entities();
        queen.setId_races(1);
        queen.setName("Queen");
        queen.setId_type(2);
        queen.setTime_creation(50);
        race.insertRaceEntities(queen);

        //Hydralisk
        Race_entities hydra = new Race_entities();
        hydra.setId_races(1);
        hydra.setName("Hydralisk");
        hydra.setId_type(2);
        hydra.setTime_creation(33);
        race.insertRaceEntities(hydra);

        //Baneling
        Race_entities baneling = new Race_entities();
        baneling.setId_races(1);
        baneling.setName("Baneling");
        baneling.setId_type(2);
        baneling.setTime_creation(20);
        race.insertRaceEntities(baneling);

        //Overseer
        Race_entities overseer = new Race_entities();
        overseer.setId_races(1);
        overseer.setName("Overseer");
        overseer.setId_type(2);
        overseer.setTime_creation(17);
        race.insertRaceEntities(overseer);

        //Roach
        Race_entities roach = new Race_entities();
        roach.setId_races(1);
        roach.setName("Roach");
        roach.setId_type(2);
        roach.setTime_creation(27);
        race.insertRaceEntities(roach);

        //Infestor
        Race_entities infest = new Race_entities();
        infest.setId_races(1);
        infest.setName("Infestor");
        infest.setId_type(2);
        infest.setTime_creation(50);
        race.insertRaceEntities(infest);

        //Mutalisk
        Race_entities muta = new Race_entities();
        muta.setId_races(1);
        muta.setName("Mutalisk");
        muta.setId_type(2);
        muta.setTime_creation(33);
        race.insertRaceEntities(muta);

        //Corruptor
        Race_entities corruptor = new Race_entities();
        corruptor.setId_races(1);
        corruptor.setName("Corruptor");
        corruptor.setId_type(2);
        corruptor.setTime_creation(40);
        race.insertRaceEntities(corruptor);

        //Ultralisk
        Race_entities ultra = new Race_entities();
        ultra.setId_races(1);
        ultra.setName("Ultralisk");
        ultra.setId_type(2);
        ultra.setTime_creation(55);
        race.insertRaceEntities(ultra);

        //Brood Lord
        Race_entities broodLord = new Race_entities();
        broodLord.setId_races(1);
        broodLord.setName("Brood Lord");
        broodLord.setId_type(2);
        broodLord.setTime_creation(34);
        race.insertRaceEntities(broodLord);

        //Swarm Host
        Race_entities sh = new Race_entities();
        sh.setId_races(1);
        sh.setName("Swarm Host");
        sh.setId_type(2);
        sh.setTime_creation(40);
        race.insertRaceEntities(sh);

        //Viper
        Race_entities viper = new Race_entities();
        viper.setId_races(1);
        viper.setName("Viper");
        viper.setId_type(2);
        viper.setTime_creation(40);
        race.insertRaceEntities(viper);

        //////////////////////PROTOSS //////////////////////
        //Probe
        Race_entities probe = new Race_entities();
        probe.setId_races(2);
        probe.setName("Probe");
        probe.setId_type(2);
        probe.setTime_creation(17);
        race.insertRaceEntities(probe);

        //Zealot
        Race_entities zealot = new Race_entities();
        zealot.setId_races(2);
        zealot.setName("Zealot");
        zealot.setId_type(2);
        zealot.setTime_creation(38);
        race.insertRaceEntities(zealot);

        //Stalker
        Race_entities stalker = new Race_entities();
        stalker.setId_races(2);
        stalker.setName("Stalker");
        stalker.setId_type(2);
        stalker.setTime_creation(42);
        race.insertRaceEntities(stalker);

        //Sentry
        Race_entities sentry = new Race_entities();
        sentry.setId_races(2);
        sentry.setName("Sentry");
        sentry.setId_type(2);
        sentry.setTime_creation(37);
        race.insertRaceEntities(sentry);

        //Observer
        Race_entities observer = new Race_entities();
        observer.setId_races(2);
        observer.setName("Observer");
        observer.setId_type(2);
        observer.setTime_creation(30);
        race.insertRaceEntities(observer);

        //Immortal
        Race_entities immo = new Race_entities();
        immo.setId_races(2);
        immo.setName("Immortal");
        immo.setId_type(2);
        immo.setTime_creation(55);
        race.insertRaceEntities(immo);

        //Warp Prism
        Race_entities warpPrism = new Race_entities();
        warpPrism.setId_races(2);
        warpPrism.setName("Warp Prism");
        warpPrism.setId_type(2);
        warpPrism.setTime_creation(50);
        race.insertRaceEntities(warpPrism);

        //Colossus
        Race_entities coloss = new Race_entities();
        coloss.setId_races(2);
        coloss.setName("Colossus");
        coloss.setId_type(2);
        coloss.setTime_creation(75);
        race.insertRaceEntities(coloss);

        //Phoenix
        Race_entities phoenix = new Race_entities();
        phoenix.setId_races(2);
        phoenix.setName("Phoenix");
        phoenix.setId_type(2);
        phoenix.setTime_creation(35);
        race.insertRaceEntities(phoenix);

        //Void Ray
        Race_entities violRay = new Race_entities();
        violRay.setId_races(2);
        violRay.setName("Void Ray");
        violRay.setId_type(2);
        violRay.setTime_creation(60);
        race.insertRaceEntities(violRay);

        //High Templar
        Race_entities ht = new Race_entities();
        ht.setId_races(2);
        ht.setName("High Templar");
        ht.setId_type(2);
        ht.setTime_creation(55);
        race.insertRaceEntities(ht);

        //Dark Templar
        Race_entities dt = new Race_entities();
        dt.setId_races(2);
        dt.setName("Dark Templar");
        dt.setId_type(2);
        dt.setTime_creation(55);
        race.insertRaceEntities(dt);

        //Archon
        Race_entities archon = new Race_entities();
        archon.setId_races(2);
        archon.setName("Archon");
        archon.setId_type(2);
        archon.setTime_creation(12);
        race.insertRaceEntities(archon);

        //Carrier
        Race_entities carrier = new Race_entities();
        carrier.setId_races(2);
        carrier.setName("Carrier");
        carrier.setId_type(2);
        carrier.setTime_creation(120);
        race.insertRaceEntities(carrier);

        //Mothership
        Race_entities mothership = new Race_entities();
        mothership.setId_races(2);
        mothership.setName("Mothership");
        mothership.setId_type(2);
        mothership.setTime_creation(100);
        race.insertRaceEntities(mothership);

        //Mothership Core
        Race_entities mothershipCorps = new Race_entities();
        mothershipCorps.setId_races(2);
        mothershipCorps.setName("Mothership Core");
        mothershipCorps.setId_type(2);
        mothershipCorps.setTime_creation(30);
        race.insertRaceEntities(mothershipCorps);

        //Oracle
        Race_entities oracle = new Race_entities();
        oracle.setId_races(2);
        oracle.setName("Oracle");
        oracle.setId_type(2);
        oracle.setTime_creation(50);
        race.insertRaceEntities(oracle);

        //Tempest
        Race_entities tempest = new Race_entities();
        tempest.setId_races(2);
        tempest.setName("Tempest");
        tempest.setId_type(2);
        tempest.setTime_creation(60);
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
