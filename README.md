# Astah Legend Plug-In

The Astah Legend Plug-in enhances your modeling tool experience by seamlessly incorporating legend capabilities. The plugin enables coloring of
diagram elements based on rules described in Groovy language.

# Screenshot

![image](https://github.com/modeldriven-hu/astah-legend/assets/8182138/30fd0bb8-6c20-4736-87d3-4defc253350b)

# Features

- Reset, load, and save legend in YAML format
- Visual attributes for legends and legend items
- Add, remove, modify, and change order of legend items
- Scripting capability in Groovy
- Edit on double click
- Auto assign color for new legend items

# How to use

1. Enter Legend name
2. Modify legend style by pressing the Configure button
3. Add new legend items by pressing the add button on the Legend items tab
4. Edit the legend item, set name, colors, and script
5. Press `Apply on diagram` button in the toolbar

# Script rules

- The script should be written in Groovy.
- It is required to output a boolean value (true or false).
- A true result signifies that the legend item will be applied, while false indicates that the legend item will not be applied.
- If the Elements only checkbox is selected, the script will not be executed for presentation elements lacking a corresponding model element (e.g., line, rectangle, image).
- The script receives two variables:
  - `presentation`: represents the presentation element (of type `IPresentation`).
  - `element`: represents a model element referenced by the presentation element (of type `IElement`).
- Example usage: "Test".equals(element.name). This condition will color each element on the diagram whose name equals "Test".

# Example scripts

## Check for name

### Checking for exact match

If we want to color a single element with a certain name, use he following script:

`"Error".equals(element.name)`

This will result in the following coloring:

![image](https://github.com/modeldriven-hu/astah-legend/assets/8182138/54ef7ead-9b32-44f2-bb39-3d030350670b)

### Checking for ending

A more realistic example is when certain rules are defined for the structure of names. An example is that a name cannot end with a certain characters, like data. So, let's use the following script:

`element.name.toLowerCase().endsWith("data")`

This will result in the following coloring:

![image](https://github.com/modeldriven-hu/astah-legend/assets/8182138/56478312-e81f-45f9-b549-d6b981c7f6b0)

## Checking for stereotype

To color the diagram based on a stereotype, for example if an element has an associated stereotype with the name `Stakeholder`, use the following script:

`element.hasStereotype("Stakeholder")`

This will result in the following coloring:

![image](https://github.com/modeldriven-hu/astah-legend/assets/8182138/14a5c17c-dfa8-4b85-9a06-99b63bc93e01)
