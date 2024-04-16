-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 16, 2024 at 06:35 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `citizen_voice`
--

-- --------------------------------------------------------

--
-- Table structure for table `citytb`
--

CREATE TABLE `citytb` (
  `city_id` int(11) NOT NULL,
  `district_id` int(11) NOT NULL,
  `city_name` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `districttb`
--

CREATE TABLE `districttb` (
  `district_id` int(11) NOT NULL,
  `state_id` int(11) NOT NULL,
  `district_name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `grouptb`
--

CREATE TABLE `grouptb` (
  `group_id` int(11) NOT NULL,
  `group_name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `optionstb`
--

CREATE TABLE `optionstb` (
  `option_id` int(11) NOT NULL,
  `qid` int(11) NOT NULL,
  `option_answer` varchar(50) NOT NULL,
  `dateOfSubmission` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `questiontb`
--

CREATE TABLE `questiontb` (
  `qid` int(11) NOT NULL,
  `question` varchar(250) NOT NULL,
  `state` varchar(10) NOT NULL,
  `district` varchar(10) NOT NULL,
  `city` varchar(10) NOT NULL,
  `zone` varchar(10) NOT NULL,
  `ward` varchar(10) NOT NULL,
  `taluka` varchar(10) NOT NULL,
  `village` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `question_city`
--

CREATE TABLE `question_city` (
  `question_city_id` int(11) NOT NULL,
  `qid` int(11) NOT NULL,
  `state_id` int(11) NOT NULL,
  `district_id` int(11) NOT NULL,
  `city_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `question_district`
--

CREATE TABLE `question_district` (
  `question_district_id` int(11) NOT NULL,
  `qid` int(11) NOT NULL,
  `state_id` int(11) NOT NULL,
  `district_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `question_state`
--

CREATE TABLE `question_state` (
  `question_state_id` int(11) NOT NULL,
  `qid` int(11) NOT NULL,
  `state_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `question_taluka`
--

CREATE TABLE `question_taluka` (
  `question_taluka_id` int(11) NOT NULL,
  `qid` int(11) NOT NULL,
  `district_id` int(11) NOT NULL,
  `state_id` int(11) NOT NULL,
  `taluka_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `question_village`
--

CREATE TABLE `question_village` (
  `question_village_id` int(11) NOT NULL,
  `qid` int(11) NOT NULL,
  `district_id` int(11) NOT NULL,
  `state_id` int(11) NOT NULL,
  `village_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `question_ward`
--

CREATE TABLE `question_ward` (
  `question_ward_id` int(11) NOT NULL,
  `qid` int(11) NOT NULL,
  `city_id` int(11) NOT NULL,
  `state_id` int(11) NOT NULL,
  `ward_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `question_zone`
--

CREATE TABLE `question_zone` (
  `question_zone_id` int(11) NOT NULL,
  `qid` int(11) NOT NULL,
  `city_id` int(11) NOT NULL,
  `state_id` int(11) NOT NULL,
  `zone_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `statetb`
--

CREATE TABLE `statetb` (
  `state_id` int(11) NOT NULL,
  `state_name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `talukatb`
--

CREATE TABLE `talukatb` (
  `taluka_id` int(11) NOT NULL,
  `district_id` int(11) NOT NULL,
  `taluka_name` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `usertb`
--

CREATE TABLE `usertb` (
  `user_id` int(11) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(50) NOT NULL,
  `email` varchar(250) NOT NULL,
  `adhaar_card_no` varchar(12) NOT NULL,
  `village_id` int(11) NOT NULL,
  `taluka_id` int(11) NOT NULL,
  `zone_id` int(11) NOT NULL,
  `city_id` int(11) NOT NULL,
  `district_id` int(11) NOT NULL,
  `state_id` int(11) NOT NULL,
  `ward_id` int(11) NOT NULL,
  `contact` varchar(20) NOT NULL,
  `gender` varchar(6) NOT NULL,
  `address` varchar(250) NOT NULL,
  `dob` varchar(100) NOT NULL,
  `zip_code` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `user_answer`
--

CREATE TABLE `user_answer` (
  `answer_id` int(11) NOT NULL,
  `qid` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `option_id` int(11) NOT NULL,
  `state_id` int(11) NOT NULL,
  `district_id` int(11) NOT NULL,
  `city_id` int(11) NOT NULL,
  `ward_id` int(11) NOT NULL,
  `zone_id` int(11) NOT NULL,
  `taluka_id` int(11) NOT NULL,
  `village_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `user_group`
--

CREATE TABLE `user_group` (
  `user_group_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `group_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `villagetb`
--

CREATE TABLE `villagetb` (
  `village_id` int(11) NOT NULL,
  `taluka_id` int(11) NOT NULL,
  `village_name` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `wardtb`
--

CREATE TABLE `wardtb` (
  `ward_id` int(11) NOT NULL,
  `zone_id` int(11) NOT NULL,
  `ward_name` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `zonetb`
--

CREATE TABLE `zonetb` (
  `zone_id` int(11) NOT NULL,
  `city_id` int(11) NOT NULL,
  `zone_name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `citytb`
--
ALTER TABLE `citytb`
  ADD PRIMARY KEY (`city_id`),
  ADD KEY `cityDistFk` (`district_id`);

--
-- Indexes for table `districttb`
--
ALTER TABLE `districttb`
  ADD PRIMARY KEY (`district_id`),
  ADD KEY `stateDisFK` (`state_id`);

--
-- Indexes for table `grouptb`
--
ALTER TABLE `grouptb`
  ADD PRIMARY KEY (`group_id`);

--
-- Indexes for table `optionstb`
--
ALTER TABLE `optionstb`
  ADD PRIMARY KEY (`option_id`),
  ADD KEY `answerQuestionFK` (`qid`);

--
-- Indexes for table `questiontb`
--
ALTER TABLE `questiontb`
  ADD PRIMARY KEY (`qid`);

--
-- Indexes for table `question_city`
--
ALTER TABLE `question_city`
  ADD PRIMARY KEY (`question_city_id`),
  ADD KEY `questionCityFK` (`qid`),
  ADD KEY `cityQuestionFK` (`city_id`),
  ADD KEY `cityStateQuestionFK` (`state_id`),
  ADD KEY `cityDistrictQuestionFK` (`district_id`);

--
-- Indexes for table `question_district`
--
ALTER TABLE `question_district`
  ADD PRIMARY KEY (`question_district_id`),
  ADD KEY `stateDistrictQuestionFK` (`state_id`),
  ADD KEY `questionDistrictFK` (`qid`),
  ADD KEY `districtQuestionFK` (`district_id`);

--
-- Indexes for table `question_state`
--
ALTER TABLE `question_state`
  ADD PRIMARY KEY (`question_state_id`),
  ADD KEY `questionStateFK` (`qid`),
  ADD KEY `stateQuestionFK` (`state_id`);

--
-- Indexes for table `question_taluka`
--
ALTER TABLE `question_taluka`
  ADD PRIMARY KEY (`question_taluka_id`),
  ADD KEY `questionTalukaFK` (`qid`),
  ADD KEY `talukaQuestionFK` (`taluka_id`),
  ADD KEY `talukaDistrictQuestionFK` (`district_id`),
  ADD KEY `talukaStateQuestionFK` (`state_id`);

--
-- Indexes for table `question_village`
--
ALTER TABLE `question_village`
  ADD PRIMARY KEY (`question_village_id`),
  ADD KEY `questionVillageFK` (`qid`),
  ADD KEY `villageQuestionFK` (`village_id`),
  ADD KEY `villageDistrictQuestionFK` (`district_id`),
  ADD KEY `villageStateQuestionFK` (`state_id`);

--
-- Indexes for table `question_ward`
--
ALTER TABLE `question_ward`
  ADD PRIMARY KEY (`question_ward_id`),
  ADD KEY `questionWardFK` (`qid`),
  ADD KEY `wardQuestionFK` (`ward_id`),
  ADD KEY `wardCityQuestionFK` (`city_id`);

--
-- Indexes for table `question_zone`
--
ALTER TABLE `question_zone`
  ADD PRIMARY KEY (`question_zone_id`),
  ADD KEY `questionZoneFK` (`qid`),
  ADD KEY `zoneCityQuestionFK` (`city_id`),
  ADD KEY `zoneStateQuestionFK` (`state_id`),
  ADD KEY `zoneQuestionFK` (`zone_id`);

--
-- Indexes for table `statetb`
--
ALTER TABLE `statetb`
  ADD PRIMARY KEY (`state_id`);

--
-- Indexes for table `talukatb`
--
ALTER TABLE `talukatb`
  ADD PRIMARY KEY (`taluka_id`),
  ADD KEY `talukaDistFK` (`district_id`);

--
-- Indexes for table `usertb`
--
ALTER TABLE `usertb`
  ADD PRIMARY KEY (`user_id`),
  ADD KEY `villageFK` (`village_id`),
  ADD KEY `talukaFK` (`taluka_id`),
  ADD KEY `zoneFK` (`zone_id`),
  ADD KEY `cityFK` (`city_id`),
  ADD KEY `stateFK` (`state_id`),
  ADD KEY `wardFK` (`ward_id`),
  ADD KEY `districtFK` (`district_id`);

--
-- Indexes for table `user_answer`
--
ALTER TABLE `user_answer`
  ADD PRIMARY KEY (`answer_id`),
  ADD KEY `answerQuestionIDFK` (`qid`),
  ADD KEY `userIDFK` (`user_id`),
  ADD KEY `optionIDFK` (`option_id`),
  ADD KEY `stateIDFK` (`state_id`),
  ADD KEY `districtIDFK` (`district_id`),
  ADD KEY `cityIDFK` (`city_id`),
  ADD KEY `wardIDFK` (`ward_id`),
  ADD KEY `zoneIDFK` (`zone_id`),
  ADD KEY `talukaIDFK` (`taluka_id`),
  ADD KEY `villageIDFK` (`village_id`);

--
-- Indexes for table `user_group`
--
ALTER TABLE `user_group`
  ADD PRIMARY KEY (`user_group_id`),
  ADD KEY `groupIDFK` (`group_id`),
  ADD KEY `groupUserIDFK` (`user_id`);

--
-- Indexes for table `villagetb`
--
ALTER TABLE `villagetb`
  ADD PRIMARY KEY (`village_id`),
  ADD KEY `villageTalukaFK` (`taluka_id`);

--
-- Indexes for table `wardtb`
--
ALTER TABLE `wardtb`
  ADD PRIMARY KEY (`ward_id`),
  ADD KEY `wardZoneFK` (`zone_id`);

--
-- Indexes for table `zonetb`
--
ALTER TABLE `zonetb`
  ADD PRIMARY KEY (`zone_id`),
  ADD KEY `zoneCityFK` (`city_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `citytb`
--
ALTER TABLE `citytb`
  MODIFY `city_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `districttb`
--
ALTER TABLE `districttb`
  MODIFY `district_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `grouptb`
--
ALTER TABLE `grouptb`
  MODIFY `group_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `optionstb`
--
ALTER TABLE `optionstb`
  MODIFY `option_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `questiontb`
--
ALTER TABLE `questiontb`
  MODIFY `qid` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `question_city`
--
ALTER TABLE `question_city`
  MODIFY `question_city_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `question_district`
--
ALTER TABLE `question_district`
  MODIFY `question_district_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `question_state`
--
ALTER TABLE `question_state`
  MODIFY `question_state_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `question_taluka`
--
ALTER TABLE `question_taluka`
  MODIFY `question_taluka_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `question_village`
--
ALTER TABLE `question_village`
  MODIFY `question_village_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `question_ward`
--
ALTER TABLE `question_ward`
  MODIFY `question_ward_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `question_zone`
--
ALTER TABLE `question_zone`
  MODIFY `question_zone_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `statetb`
--
ALTER TABLE `statetb`
  MODIFY `state_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `talukatb`
--
ALTER TABLE `talukatb`
  MODIFY `taluka_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `usertb`
--
ALTER TABLE `usertb`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `user_answer`
--
ALTER TABLE `user_answer`
  MODIFY `answer_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `user_group`
--
ALTER TABLE `user_group`
  MODIFY `user_group_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `villagetb`
--
ALTER TABLE `villagetb`
  MODIFY `village_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `wardtb`
--
ALTER TABLE `wardtb`
  MODIFY `ward_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `zonetb`
--
ALTER TABLE `zonetb`
  MODIFY `zone_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `citytb`
--
ALTER TABLE `citytb`
  ADD CONSTRAINT `cityDistFk` FOREIGN KEY (`district_id`) REFERENCES `districttb` (`district_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `districttb`
--
ALTER TABLE `districttb`
  ADD CONSTRAINT `stateDisFK` FOREIGN KEY (`state_id`) REFERENCES `statetb` (`state_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `optionstb`
--
ALTER TABLE `optionstb`
  ADD CONSTRAINT `answerQuestionFK` FOREIGN KEY (`qid`) REFERENCES `questiontb` (`qid`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `question_city`
--
ALTER TABLE `question_city`
  ADD CONSTRAINT `cityDistrictQuestionFK` FOREIGN KEY (`district_id`) REFERENCES `districttb` (`district_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `cityQuestionFK` FOREIGN KEY (`city_id`) REFERENCES `citytb` (`city_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `cityStateQuestionFK` FOREIGN KEY (`state_id`) REFERENCES `statetb` (`state_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `questionCityFK` FOREIGN KEY (`qid`) REFERENCES `questiontb` (`qid`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `question_district`
--
ALTER TABLE `question_district`
  ADD CONSTRAINT `districtQuestionFK` FOREIGN KEY (`district_id`) REFERENCES `districttb` (`district_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `questionDistrictFK` FOREIGN KEY (`qid`) REFERENCES `questiontb` (`qid`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `stateDistrictQuestionFK` FOREIGN KEY (`state_id`) REFERENCES `statetb` (`state_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `question_state`
--
ALTER TABLE `question_state`
  ADD CONSTRAINT `questionStateFK` FOREIGN KEY (`qid`) REFERENCES `questiontb` (`qid`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `stateQuestionFK` FOREIGN KEY (`state_id`) REFERENCES `statetb` (`state_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `question_taluka`
--
ALTER TABLE `question_taluka`
  ADD CONSTRAINT `questionTalukaFK` FOREIGN KEY (`qid`) REFERENCES `questiontb` (`qid`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `talukaDistrictQuestionFK` FOREIGN KEY (`district_id`) REFERENCES `districttb` (`district_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `talukaQuestionFK` FOREIGN KEY (`taluka_id`) REFERENCES `talukatb` (`taluka_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `talukaStateQuestionFK` FOREIGN KEY (`state_id`) REFERENCES `statetb` (`state_id`) ON UPDATE CASCADE;

--
-- Constraints for table `question_village`
--
ALTER TABLE `question_village`
  ADD CONSTRAINT `questionVillageFK` FOREIGN KEY (`qid`) REFERENCES `questiontb` (`qid`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `villageDistrictQuestionFK` FOREIGN KEY (`district_id`) REFERENCES `districttb` (`district_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `villageQuestionFK` FOREIGN KEY (`village_id`) REFERENCES `villagetb` (`village_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `villageStateQuestionFK` FOREIGN KEY (`state_id`) REFERENCES `statetb` (`state_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `question_ward`
--
ALTER TABLE `question_ward`
  ADD CONSTRAINT `questionWardFK` FOREIGN KEY (`qid`) REFERENCES `questiontb` (`qid`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `wardCityQuestionFK` FOREIGN KEY (`city_id`) REFERENCES `citytb` (`city_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `wardQuestionFK` FOREIGN KEY (`ward_id`) REFERENCES `wardtb` (`ward_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `question_zone`
--
ALTER TABLE `question_zone`
  ADD CONSTRAINT `questionZoneFK` FOREIGN KEY (`qid`) REFERENCES `questiontb` (`qid`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `zoneCityQuestionFK` FOREIGN KEY (`city_id`) REFERENCES `citytb` (`city_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `zoneQuestionFK` FOREIGN KEY (`zone_id`) REFERENCES `zonetb` (`zone_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `zoneStateQuestionFK` FOREIGN KEY (`state_id`) REFERENCES `statetb` (`state_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `talukatb`
--
ALTER TABLE `talukatb`
  ADD CONSTRAINT `talukaDistFK` FOREIGN KEY (`district_id`) REFERENCES `districttb` (`district_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `usertb`
--
ALTER TABLE `usertb`
  ADD CONSTRAINT `cityFK` FOREIGN KEY (`city_id`) REFERENCES `citytb` (`city_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `districtFK` FOREIGN KEY (`district_id`) REFERENCES `districttb` (`district_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `stateFK` FOREIGN KEY (`state_id`) REFERENCES `statetb` (`state_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `talukaFK` FOREIGN KEY (`taluka_id`) REFERENCES `talukatb` (`taluka_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `villageFK` FOREIGN KEY (`village_id`) REFERENCES `villagetb` (`village_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `wardFK` FOREIGN KEY (`ward_id`) REFERENCES `wardtb` (`ward_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `zoneFK` FOREIGN KEY (`zone_id`) REFERENCES `zonetb` (`zone_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `user_answer`
--
ALTER TABLE `user_answer`
  ADD CONSTRAINT `answerQuestionIDFK` FOREIGN KEY (`qid`) REFERENCES `questiontb` (`qid`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `cityIDFK` FOREIGN KEY (`city_id`) REFERENCES `citytb` (`city_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `districtIDFK` FOREIGN KEY (`district_id`) REFERENCES `districttb` (`district_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `optionIDFK` FOREIGN KEY (`option_id`) REFERENCES `optionstb` (`option_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `stateIDFK` FOREIGN KEY (`state_id`) REFERENCES `statetb` (`state_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `talukaIDFK` FOREIGN KEY (`taluka_id`) REFERENCES `talukatb` (`taluka_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `userIDFK` FOREIGN KEY (`user_id`) REFERENCES `usertb` (`user_id`),
  ADD CONSTRAINT `villageIDFK` FOREIGN KEY (`village_id`) REFERENCES `villagetb` (`village_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `wardIDFK` FOREIGN KEY (`ward_id`) REFERENCES `wardtb` (`ward_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `zoneIDFK` FOREIGN KEY (`zone_id`) REFERENCES `zonetb` (`zone_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `user_group`
--
ALTER TABLE `user_group`
  ADD CONSTRAINT `groupIDFK` FOREIGN KEY (`group_id`) REFERENCES `grouptb` (`group_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `groupUserIDFK` FOREIGN KEY (`user_id`) REFERENCES `usertb` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `villagetb`
--
ALTER TABLE `villagetb`
  ADD CONSTRAINT `villageTalukaFK` FOREIGN KEY (`taluka_id`) REFERENCES `talukatb` (`taluka_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `wardtb`
--
ALTER TABLE `wardtb`
  ADD CONSTRAINT `wardZoneFK` FOREIGN KEY (`zone_id`) REFERENCES `zonetb` (`zone_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `zonetb`
--
ALTER TABLE `zonetb`
  ADD CONSTRAINT `zoneCityFK` FOREIGN KEY (`city_id`) REFERENCES `citytb` (`city_id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
