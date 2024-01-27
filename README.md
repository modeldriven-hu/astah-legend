# Astah Legend Plug-In

The Astah Legend Plug-in enhances your modeling tool experience by seamlessly incorporating legend capabilities. The plugin enables coloring of
diagram elements based on rules described in Groovy language.

# Screenshot

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
