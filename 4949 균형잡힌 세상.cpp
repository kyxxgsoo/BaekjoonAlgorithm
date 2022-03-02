#include <iostream>
#include <string>
#include <stack>

using namespace std;

int main()
{
	while (true)
	{
		bool check = false;
		string str;
		stack<char> s;
		getline(cin, str);

		if (str == ".")
		{
			break;
		}

		for (int i = 0; i < str.size(); i++)
		{
			if (str[i] == '(' || str[i] == '[')
			{
				s.push(str[i]);
			}

			if (str[i] == ')')
			{
				if (!s.empty())
				{
					if (s.top() == '(')
					{
						s.pop();
					}
					else
					{
						check = true;
						break;
					}
				}
				else
				{
					check = true;
					break;
				}
			}
			if (str[i] == ']')
			{
				if (!s.empty())
				{
					if (s.top() == '[')
					{
						s.pop();
					}
					else
					{
						check = true;
						break;
					}
				}
				else
				{
					check = true;
					break;
				}
			}
		}
		if (s.empty() && !check)
		{
			cout << "yes\n";
		}
		else
		{
			cout << "no\n";
		}
	}
}