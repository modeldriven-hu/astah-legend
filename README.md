# Astah Legend Plug-In

Add legend support for Astah.

## Requirements

- Apply legend item rule on each diagram element
- Create a legend widget on the diagram
- Each legend shall have
    - [1] Name
    - [1] Style
        - Background color
        - Line color
        - Line width
        - Line type
        - Roundness
    - [0..*] Legend items
        - Name
        - Style
        - Background color
        - Text color
        - ...
        - Rule [describing the rule in Groovy, like hasSterepotype(item, "Subsystem") ]
- Ability to manage legends
- Create a new legend
- Modify a legend
- Change name
- Change style
- Add legend item
- Modify legend item
- Delete legend item
- Change legend item order
- Delete a legend
- Legend repository? Does it make sense to have anything like that?    
      
